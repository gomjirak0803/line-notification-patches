package app.linenotifications.extension;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import app.linenotifications.extension.core.NotificationPolicy;

/** Adapter for the inspected 26.16.0 / 261600106 DEX only. Never writes LINE's database. */
final class NativeLine {
    private NativeLine() {}

    // Server ids bound the native read boundary, but are not necessarily chronological
    // within a Messaging API batch. Select the same latest-by-time order used to render.
    static final String RECENT_MESSAGES_SQL =
            "SELECT server_id, created_time, from_mid, content FROM chat_history "
            + "WHERE chat_id = ? AND from_mid IS NOT NULL AND from_mid != ? "
            + "AND CAST(server_id AS INTEGER) > ? "
            + "ORDER BY created_time DESC, CAST(server_id AS INTEGER) DESC LIMIT ?";

    static Class<?> type(String name) throws ClassNotFoundException {
        return Class.forName(name, false, Settings.context().getClassLoader());
    }

    static Object field(Object instance, String name) throws ReflectiveOperationException {
        Field field = instance.getClass().getField(name);
        return field.get(instance);
    }

    static String account() throws ReflectiveOperationException {
        Class<?> providerType = type("ap3.b");
        Object key = providerType.getField("k0").get(null);
        Object provider = type("sc0.f").getMethod("a", Context.class, type("sc0.a"))
                .invoke(null, Settings.context(), key);
        Object profile = providerType.getMethod("getProfile").invoke(provider);
        String account = (String) field(profile, "b");
        if (account == null || account.isEmpty()) throw new IllegalStateException("No active account");
        return account;
    }

    static boolean previewsAllowed() throws ReflectiveOperationException {
        return (Boolean) type("nn8.i").getMethod("c").invoke(null);
    }

    static boolean muted(String chat) throws ReflectiveOperationException {
        Object settings = type("nn8.c").getConstructor(boolean.class).newInstance(false);
        Object dto = settings.getClass().getMethod("a", String.class).invoke(settings, chat);
        return !(Boolean) dto.getClass().getMethod("c").invoke(dto);
    }

    static boolean notificationEnabled(Object manager, String chat) throws ReflectiveOperationException {
        return (Boolean) type("wk8.l0").getMethod("x", String.class).invoke(manager, chat);
    }

    static final class Chat {
        final String name, readUp;
        final int unread;
        Chat(String name, String readUp, int unread) {
            this.name = name; this.readUp = readUp; this.unread = unread;
        }
    }

    static Chat chat(String chatId) throws ReflectiveOperationException {
        Object manager = type("wk8.a2").getMethod("a", Context.class, boolean.class)
                .invoke(null, Settings.context(), false);
        Object repository = type("wk8.l0").getMethod("r").invoke(manager);
        Object data = type("ue3.k").getMethod("u1", String.class).invoke(repository, chatId);
        if (data == null) return null;
        int unread = (Integer) field(field(data, "n"), "c");
        if (unread < 0) throw new IllegalStateException("Invalid unread metadata");
        return new Chat((String) field(data, "b"), (String) field(data, "m"), unread);
    }

    static boolean regularChat(String chat) {
        // Verified LINE IDs: user, legacy room, group. OpenChat has a separate data model.
        return chat != null && chat.matches("[ucr][0-9a-f]{32}");
    }

    /** An action must not precede the incoming push's local save. Reads metadata only. */
    static boolean readReady(Context context, String chat, String postedMessageId) {
        if (!regularChat(chat) || postedMessageId == null) return false;
        try {
            long posted = Long.parseLong(postedMessageId);
            if (posted <= 0) return false;
            String account = account();
            Chat state = chat(chat);
            if (state == null || state.unread == 0) return false;
            long readUp = state.readUp == null || state.readUp.isEmpty() ? 0 : Long.parseLong(state.readUp);
            if (posted <= readUp) return false;
            boolean saved;
            try (SQLiteDatabase db = SQLiteDatabase.openDatabase(
                    context.getDatabasePath("naver_line").getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
                 Cursor cursor = db.rawQuery(
                         "SELECT 1 FROM chat_history WHERE chat_id = ? "
                         + "AND server_id = ? AND from_mid IS NOT NULL AND from_mid != ? LIMIT 1",
                         new String[]{chat, postedMessageId, account})) {
                saved = cursor.moveToFirst();
            }
            // Account replacement can also replace the local database while this runs.
            return saved && account.equals(account());
        } catch (ReflectiveOperationException | RuntimeException ignored) {
            return false;
        }
    }

    static List<NotificationPolicy.Message> recent(String chat, String account, Chat state) {
        long lower = state.readUp == null || state.readUp.isEmpty() ? 0 : Long.parseLong(state.readUp);
        List<NotificationPolicy.Message> result = new ArrayList<>();
        if (state.unread == 0) return result;
        // A retained conversation can contain many messages by the same sender. Resolve
        // each name once for this snapshot without retaining contact data across updates.
        Map<String, String> senders = new HashMap<>();
        // Read only; no private database is copied, persisted, uploaded, or logged.
        try (SQLiteDatabase db = SQLiteDatabase.openDatabase(
                Settings.context().getDatabasePath("naver_line").getAbsolutePath(), null,
                SQLiteDatabase.OPEN_READONLY);
             Cursor cursor = db.rawQuery(
                     RECENT_MESSAGES_SQL,
                     new String[]{chat, account, Long.toString(lower),
                             Integer.toString(Math.min(NotificationPolicy.MAX_RECENT_MESSAGES, state.unread))})) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0), senderId = cursor.getString(2), body = cursor.getString(3);
                long numericId;
                try { numericId = Long.parseLong(id); } catch (NumberFormatException ignored) { continue; }
                if (body == null || body.isEmpty()) body = "[첨부 메시지]";
                String sender = senders.get(senderId);
                if (sender == null) {
                    sender = senderName(senderId);
                    senders.put(senderId, sender);
                }
                result.add(new NotificationPolicy.Message(id, cursor.getLong(1), numericId,
                        senderId, sender, body));
            }
        }
        return result;
    }

    private static String senderName(String mid) {
        try (SQLiteDatabase db = SQLiteDatabase.openDatabase(
                Settings.context().getDatabasePath("contact").getAbsolutePath(), null,
                SQLiteDatabase.OPEN_READONLY);
             Cursor cursor = db.rawQuery("SELECT coalesce(nullif(overridden_name,''), "
                     + "nullif(address_book_name,''), profile_name) FROM contacts WHERE mid = ? LIMIT 1",
                     new String[]{mid})) {
            if (cursor.moveToFirst() && cursor.getString(0) != null) return cursor.getString(0);
        } catch (RuntimeException ignored) { }
        return "메시지";
    }
}
