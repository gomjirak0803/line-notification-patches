LINE 26.16.0 (261600106)용 독립 실험 패치입니다. Morphe Patcher 2.3.0이 필요합니다.

- 조용히 받기·완전 숨김, 대화형 알림과 전체 미확인 수, 추천 답장 제거, 방 전체 읽음을 제공합니다.
- 0.1.9는 `Not Too Much Silent` 켜짐 시 채팅 목록 길게 누르기 알림 끄기/켜기와 목록 음소거 아이콘·메뉴 라벨에도 로컬 조용히 받기를 적용하며, Android Morphe Manager의 원격 메타데이터(`created_at`) 파싱 호환성을 수정합니다.
- S10e Android 12에서 채팅 목록 길게 누르기 왕복 전환·무음/일반 채널 백그라운드 수신·오프라인 읽음 후 재연결 `[1]` 초기화를 확인했습니다. 다른 환경과 예외 시험은 docs/DEVICE_TESTS.md를 확인하세요.
- Restore push registration은 Firebase 등록의 인증서 식별값을 변경하는 별도 선택 패치입니다.
- 원본·패치된 전체 LINE APK와 서명키는 배포하지 않습니다. 원본 APKM은 사용자가 준비합니다.
- GPL-3.0 및 NOTICE 추가 조건을 적용하며 대응 소스·빌드 방법·타사 출처를 함께 제공합니다.
- 배포자 서명은 아직 없습니다. SHA256SUMS는 파일 비교용입니다.

Sources → + → Remote에서 https://github.com/gomjirak0803/line-notification-patches 를 추가하세요.
Pre-release patches와 Experimental app versions를 켜고 원본 LINE 26.16.0 APKM에 적용하세요.
