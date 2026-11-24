## What's New in 0.1.16-dev

- **Account isolation for held pending notifications**: Keys `PENDING_POSTS` and `PENDING_TIMEOUTS` by `ChatKey(account, chat)` and stamps each `PendingPost` with the receiving account, re-checking `NativeLine.account()` before `transform()` and before `notify()` (as well as on save completion and timeout flush) so notifications held awaiting local save are discarded immediately if the active LINE account switches.
- **Preserve other rooms' group summaries when snoozing or muting one room**: Replaces `clearSummaries()` across **Quiet 1h**, notification mute, room hide, and hidden-chat pruning with `Notifications.cancelChatNotifications` and `NotificationPolicy.resolveGroupSummary`, keeping active notifications for remaining chats and rewriting `shortcutId`, `line.chat.id`, `line.message.id`, title/text, and `publicVersion` cleanly on Android `recoverBuilder` (and canceling the group summary only when 0 child notifications remain).
- **Lock and generation guard for thumbnail staging**: Adds a `PREVIEW_FILE_LOCK`-guarded `mediaPreviewGeneration` counter (`clearMediaPreviewCache` increments generation and cleans empty directories) and re-verifies settings, privacy, unread count, and active account after `NativeLine.mediaPreviews()` returns so disabling **Show photo & sticker previews** mid-load never recreates cached files or attaches stale previews.
- **Full Python test verification in build & CI**: Updates `scripts/build.py` and `.github/workflows/release.yml` to run the complete `tests/test_*.py` suite (25 tests, executed after `scripts/prepare_release.py` and before publishing) so i18n, bundle metadata, sender, and SQLite regressions are gated on every release.

### Included Patches (LINE `26.16.0` / `261600106`, Patcher `2.3.0`, all `default = true`)
- `Notification settings`: Adds localized patch settings UI & notification button presets.
- `Not Too Much Silent`: Local silent mode (chat menu, chat-list long-press, notification shade) with opt-in `@mention` & keyword alert bypass + complete hide.
- `More Chat Info`: Android `MessagingStyle` conversation preview (configurable `1–25` recent unread) + total unread count + typed & detailed attachment labels + optional inline photo/sticker previews + local-cache sender avatars.
- `No reply`: Hides smart-reply chips while keeping manual inline reply.
- `Mark as read`: Marks whole regular chat read via LINE's native chat-list updater.
- `Restore push registration`: Restores Firebase installation registration after re-signing (`X-Android-Cert` only).

### Verification & Notes
- Verified with 215 `NotificationPolicy` assertions, 25 Python tests, 2,078 static APK contracts (ARM64 & Universal; 2,016 `Mark as read`-only), compiled `resources.arsc` checks (77 keys × 7 locales), and live Galaxy S10e verification of two-room `Quiet 1h` summary preservation and last-room summary cleanup.
- Original/patched LINE APKs, APKMs, and signing keys are never distributed. Provide your own official LINE `26.16.0` APKM.
- Licensed under GPL-3.0 with `NOTICE`, `THIRD_PARTY_NOTICES.md`, source archive, and `SHA256SUMS.txt`.
