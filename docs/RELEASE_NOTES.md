LINE 26.16.0 (261600106)용 독립 실험 패치입니다. Morphe Patcher 2.3.0이 필요합니다.

- 조용히 받기·완전 숨김, 대화형 알림과 전체 미확인 수, 추천 답장 제거, 방 전체 읽음을 제공합니다.
- 0.1.11은 `More Chat Info`로 펼친 대화형 알림(`MessagingStyle`)에 발신자 프로필 사진을 표시합니다. 1:1 채팅은 원본 알림 아이콘을 재사용하고, 그룹 채팅 다중 발신자는 `contacts.picture_path`와 LINE의 Glide 로컬 캐시 전용(`onlyRetrieveFromCache(true)`)으로 읽어 추가 네트워크 요청 없이 표시합니다.
- S10e Android 12 실기기에서 펼친 알림 프로필 사진 정상 표시와 ARM64/Universal 1,075개 정적 계약 검사를 확인했습니다. 상세 범위는 docs/DEVICE_TESTS.md를 확인하세요.
- Restore push registration은 Firebase 등록의 인증서 식별값을 변경하는 별도 선택 패치입니다.
- 원본·패치된 전체 LINE APK와 서명키는 배포하지 않습니다. 원본 APKM은 사용자가 준비합니다.
- GPL-3.0 및 NOTICE 추가 조건을 적용하며 대응 소스·빌드 방법·타사 출처를 함께 제공합니다.
- 배포자 서명은 아직 없습니다. SHA256SUMS는 파일 비교용입니다.

Sources → + → Remote에서 https://github.com/gomjirak0803/line-notification-patches 를 추가하세요.
Pre-release patches와 Experimental app versions를 켜고 원본 LINE 26.16.0 APKM에 적용하세요.
