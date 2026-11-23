Independent experimental Morphe patches for LINE 26.16.0 (`versionCode 261600106`). Requires Morphe Patcher 2.3.0.

- Features: `Not Too Much Silent` (local quiet mode + complete hide), `More Chat Info` (Android `MessagingStyle` conversation preview + native total unread count + typed attachment labels + sender avatars from local caches only), `No reply` (hides smart-reply chips while keeping manual inline reply), `Mark as read` (marks whole regular chat read via LINE's native chat-list updater), and optional `Restore push registration`.
- **0.1.13-dev**: Distinguishes non-text attachment placeholders in `More Chat Info` by reading `chat_history.attachement_type` across all 7 locales (49 keys total): `[Photo]`, `[Video]`, `[Sticker]`, `[Voice message]`, `[File]`, `[Location]`, `[Contact]`, `[Call]`, `[Gift]`, and `[Music]`, falling back to `[Attachment]` for other types.
- **0.1.12-dev**: Adds full multi-language (i18n) support across 7 locales (`values`, `values-ko`, `values-ja`, `values-zh-rTW`, `values-zh-rCN`, `values-th`, `values-in`). The four canonical patch names stay in English.
- Verified with 130 `NotificationPolicy` assertions, 19 Python tests, 1,187 static APK contract assertions (ARM64 & Universal), and compiled `resources.arsc` checks confirming all 49 keys in all 7 locales. See `docs/DEVICE_TESTS.md` for real-device and cross-environment verification scope.
- `Restore push registration` is an optional, default-off patch that overrides only the `X-Android-Cert` header on Firebase Installations requests.
- Original/patched LINE APKs, APKMs, and signing keys are never distributed. Provide your own official LINE 26.16.0 APKM.
- Licensed under GPL-3.0 with `NOTICE` and `THIRD_PARTY_NOTICES.md`; corresponding source archive and build scripts are included.
- Bundle publisher signatures are not yet enabled; `SHA256SUMS.txt` is provided for file integrity comparison.

Add via **Sources → + → Remote**: `https://github.com/gomjirak0803/line-notification-patches`
Enable **Pre-release patches** and **Experimental app versions**, then patch your official LINE 26.16.0 APKM in Expert mode.
