## What's New in 0.1.13-dev

- **Typed attachment labels in `More Chat Info`**: Distinguishes non-text messages via `chat_history.attachement_type` across all 7 locales (`[Photo]`, `[Video]`, `[Sticker]`, `[Voice message]`, `[File]`, `[Location]`, `[Contact]`, `[Call]`, `[Gift]`, `[Music]`, with `[Attachment]` fallback).
- **7-locale i18n (`0.1.12-dev`+)**: All 49 UI and notification strings follow LINE/system language across English (default), Korean, Japanese, Traditional Chinese, Simplified Chinese, Thai, and Indonesian. Canonical patch names stay in English.
- **Expanded notification avatars (`0.1.11-dev`+)**: Shows sender profile photos in expanded `More Chat Info` notifications using original icons (1:1) and LINE's local Glide cache only (group chats, zero network requests).

### Included Patches (LINE `26.16.0` / `261600106`, Patcher `2.3.0`)
- `Not Too Much Silent`: Local silent mode (chat menu, chat-list long-press, notification shade) + complete hide.
- `More Chat Info`: Android `MessagingStyle` conversation preview (up to 25 unread) + total unread count + typed attachment labels + local-cache sender avatars.
- `No reply`: Hides smart-reply chips while keeping manual inline reply.
- `Mark as read`: Marks whole regular chat read via LINE's native chat-list updater.
- `Restore push registration` *(optional, default off)*: Overrides only `X-Android-Cert` on Firebase Installations requests.

### Verification & Notes
- Verified with 130 `NotificationPolicy` assertions, 20 Python tests, 1,187 static APK contracts (ARM64 & Universal), compiled `resources.arsc` checks (49 keys × 7 locales), and physical Galaxy S10e Android 12 live tests.
- Original/patched LINE APKs, APKMs, and signing keys are never distributed. Provide your own official LINE `26.16.0` APKM in Expert mode.
- Licensed under GPL-3.0 with `NOTICE`, `THIRD_PARTY_NOTICES.md`, source archive, and `SHA256SUMS.txt`.
