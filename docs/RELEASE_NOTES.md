## What's New in 0.1.17-dev

- **Verified account required for single-room summary preservation**: Updates `NotificationPolicy.resolveGroupSummary` so unverified (`null`) child account stamps always fall back to `KEEP_GENERIC` rather than copying another notification's title, body, or tap action under a new account.
- **Per-slot generation tracking & cross-chat pending cleanup**: Adds monotonic per-`(tag, id)` slot generation tokens (`SLOT_GENERATIONS`) and cross-chat pending slot clearing (`removePendingSlotLocked`), ensuring a delayed local-save callback or timeout from room A can never overwrite or cancel a newer notification posted on that slot by room B.
- **Safe generic summary routing**: When rebuilding a multi-room `KEEP_GENERIC` summary, clears room-specific `line.chat.id` / `line.message.id` and hidden-room `contentIntent` (replacing with a launcher `PendingIntent` and tagging `GENERIC_SUMMARY`) while still recognizing generic summaries for cleanup when remaining rooms are dismissed or silenced.
- **Post-load read-state recheck & exact DB push readiness**: Re-verifies `unread` and `readUp` after `NativeLine.mediaPreviews()` returns via `snapshotConsistent` (performing one bounded DB re-query if read state changed mid-load), requires exact `sourceOrder == posted` matching or confirmed DB row existence (`NativeLine.messageStored` / `MESSAGE_EXISTS_SQL`) in `NotificationPolicy.previewState`, and passes `success` through `ChatNotifications.change` so notification-shade mute only cancels notifications on success.
- **Exact chat-list timestamps & surrogate-safe truncation**: Requires exact `rowCreatedTimeMillis == expectedTimeMillis` matching and `nativeText`-scoped `CHAT_LIST_CACHE` keys before replacing chat-list previews, and preserves UTF-16 surrogate pairs when truncating 80-character file/location details.

### Included Patches (LINE `26.16.0` / `261600106`, Patcher `2.3.0`, all `default = true`)
- `Notification settings`: Adds localized patch settings UI & notification button presets.
- `Not Too Much Silent`: Local silent mode (chat menu, chat-list long-press, notification shade) with opt-in `@mention` & keyword alert bypass + complete hide.
- `More Chat Info`: Android `MessagingStyle` conversation preview (configurable `1–25` recent unread) + total unread count + typed & detailed attachment labels + optional inline photo/sticker previews + local-cache sender avatars.
- `No reply`: Hides smart-reply chips while keeping manual inline reply.
- `Mark as read`: Marks whole regular chat read via LINE's native chat-list updater.
- `Restore push registration`: Restores Firebase installation registration after re-signing (`X-Android-Cert` only).

### Verification & Notes
- Verified with 223 `NotificationPolicy` assertions, 26 Python tests, 2,178 static APK contracts (ARM64 & Universal; 2,116 `Mark as read`-only), compiled `resources.arsc` checks (77 keys × 7 locales), and live Galaxy S10e verification.
- Original/patched LINE APKs, APKMs, and signing keys are never distributed. Provide your own official LINE `26.16.0` APKM.
- Licensed under GPL-3.0 with `NOTICE`, `THIRD_PARTY_NOTICES.md`, source archive, and `SHA256SUMS.txt`.
