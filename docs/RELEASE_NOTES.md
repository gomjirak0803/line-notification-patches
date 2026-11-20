LINE 26.16.0 (261600106)용 독립 실험 패치입니다. Morphe Patcher 2.3.0이 필요합니다.

- 조용히 받기·완전 숨김, 대화형 알림과 전체 미확인 수, 추천 답장 제거, 방 전체 읽음을 제공합니다.
- 0.1.10은 Android 15/16(`targetSdk=36`) edge-to-edge 강제 환경에서 알림 패치 설정 화면(`SettingsPage`) 헤더가 상태바·컷아웃과 겹치던 문제를 수정하고, `More Chat Info` DB 조회 실패 시 일반 알림이 삭제되지 않도록 예외 격리 및 미사용 리소스(`NotificationBadgeResources`) 정리를 반영합니다.
- Android 16 에뮬레이터·S22 Ultra(One UI 8.0) 진단 검증과 S10e(Android 12 / One UI 4.1) 실기기 업데이트·설정 화면 회귀를 확인했습니다. 상세 범위는 docs/DEVICE_TESTS.md를 확인하세요.
- Restore push registration은 Firebase 등록의 인증서 식별값을 변경하는 별도 선택 패치입니다.
- 원본·패치된 전체 LINE APK와 서명키는 배포하지 않습니다. 원본 APKM은 사용자가 준비합니다.
- GPL-3.0 및 NOTICE 추가 조건을 적용하며 대응 소스·빌드 방법·타사 출처를 함께 제공합니다.
- 배포자 서명은 아직 없습니다. SHA256SUMS는 파일 비교용입니다.

Sources → + → Remote에서 https://github.com/gomjirak0803/line-notification-patches 를 추가하세요.
Pre-release patches와 Experimental app versions를 켜고 원본 LINE 26.16.0 APKM에 적용하세요.
