## What's New in 0.1.14-dev

- **Alert on `@mentions` in quiet chats (`Not Too Much Silent`)**: Opt-in setting (`@멘션 시 알림 울리기` in Korean) that restores LINE's normal sound and vibration in quiet chats when someone mentions you or `@All` (`MENTION` `"MENTIONEES"` metadata). Completely hidden chats remain suppressed.
- **Alert on keywords in quiet chats (`Not Too Much Silent`)**: Opt-in setting (`키워드 알림 울리기` and `알림 키워드 설정` in Korean) that alerts normally in quiet chats when a message matches up to 50 comma- or newline-separated keywords (max 64 chars each, NFC + case-insensitive across text, `FILE_NAME`, and location metadata). Completely hidden chats stay suppressed.
- **Detailed `[File]` & `[Location]` labels across notifications, popups, and chat list (`More Chat Info`)**: Appends sanitized local filename (`[File] report.pdf`) and place name/address (`[Location] Gangnam Station`) from `chat_history` metadata, updates popup/heads-up `tickerText` (briefly holding uncommitted pushes up to 1.2s until local save completes), and applies typed attachment labels to the LINE chat list (`Lf22/i;`).
- **Configurable displayed message count (`More Chat Info`)**: Adds a **Displayed messages** (`표시할 메시지 개수` in Korean) selector (`1, 3, 5, 8, 10, 15, 20, 25`, default `25`) while keeping the full native unread badge (`Room Name  [N]`).
- **Inline photo, video & sticker thumbnail previews (`More Chat Info`, opt-in)**: Adds **Show photo & sticker previews** (`사진·스티커 미리보기 표시` in Korean), checking local files first and loading uncached thumbnails on demand via LINE's built-in Glide image loader (`e80.d`, `line.sticker.url`, `su5.o`), staging resized thumbnails (PNG/JPEG 384/512px via `LineCommonFileProvider`, up to 4 per notification) via `MessagingStyle.Message.setData`. Makes zero extra requests when disabled.
- **Configurable notification buttons (`Notification settings`, `0.1.14-dev`)**: Adds a **Notification buttons** (`알림 버튼 구성` in Korean) preset selector including **Read · Quiet 1h · Reply** (adds a local 1-hour room snooze button without server mute sync), **Read · Mute · Reply**, **Read · Reply**, **Quiet 1h · Reply**, **Read · Quiet 1h**, **Read only**, **Reply only**, and **No buttons**.
- **Typed attachment labels (`0.1.13-dev`+)**: Distinguishes `[Photo]`, `[Video]`, `[Sticker]`, `[Voice message]`, `[File]`, `[Location]`, `[Contact]`, `[Call]`, `[Gift]`, `[Music]`, and `[Attachment]` across all 7 locales.
- **7-locale i18n (`0.1.12-dev`+) & expanded avatars (`0.1.11-dev`+)**: All 77 UI and notification strings follow LINE/system language (`values`, `ko`, `ja`, `zh-rTW`, `zh-rCN`, `th`, `in`), and expanded notifications show sender avatars from original icons / local Glide cache only.

### Included Patches (LINE `26.16.0` / `261600106`, Patcher `2.3.0`)
- `Not Too Much Silent`: Local silent mode (chat menu, chat-list long-press, notification shade) with opt-in `@mention` & keyword alert bypass + complete hide.
- `More Chat Info`: Android `MessagingStyle` conversation preview (configurable `1–25` recent unread) + total unread count + typed & detailed attachment labels + optional inline photo/sticker previews + local-cache sender avatars.
- `No reply`: Hides smart-reply chips while keeping manual inline reply.
- `Mark as read`: Marks whole regular chat read via LINE's native chat-list updater.
- `Restore push registration` *(optional, default off)*: Overrides only `X-Android-Cert` on Firebase Installations requests.

### Verification & Notes
- Verified with 209 `NotificationPolicy` assertions, 24 Python tests, 1,940 static APK contracts (ARM64 & Universal; 1,878 `Mark as read`-only), and compiled `resources.arsc` checks (77 keys × 7 locales).
- Original/patched LINE APKs, APKMs, and signing keys are never distributed. Provide your own official LINE `26.16.0` APKM in Expert mode.
- Licensed under GPL-3.0 with `NOTICE`, `THIRD_PARTY_NOTICES.md`, source archive, and `SHA256SUMS.txt`.
