# Morphe에서 사용·공개하는 방법

확인일: 2026-11-18. LINE 26.16.0용 독립 실험 패치입니다. [공개 상태와 검증 범위](PUBLICATION_STATUS.md)를 확인하세요.

## 원격 소스로 추가

1. Patcher 2.3.0을 지원하는 Morphe Manager를 사용합니다.
2. [Manager에 소스 추가](https://morphe.software/add-source?github=gomjirak0803/line-notification-patches)를 열거나 Sources → + → Remote에 `https://github.com/gomjirak0803/line-notification-patches`를 넣습니다.
3. 소스의 **Pre-release patches**, **Experimental app versions**를 켭니다. 앱 자체의 사전 업데이트 설정과는 별도입니다.
4. Expert mode에서 본인이 준비한 LINE 26.16.0 원본 APKM 전체를 선택하고 필요한 패치를 적용합니다. 자세한 안내는 [README](../README.md)와 [호환성 문서](COMPATIBILITY.md)를 따릅니다.

Desktop에서 공개 주소 다운로드와 패치 로딩을 확인했습니다. Manager UI에서 직접 가져오는 시험은 아직 수행하지 않았습니다. [공식 Manager 안내](https://github.com/MorpheApp/morphe-manager/blob/main/docs/patch-sources.md)

## 파일로 가져오기

[릴리스](https://github.com/gomjirak0803/line-notification-patches/releases/tag/v0.1.8-dev)의 `.mpp`를 내려받아 Sources → + → Local에서 선택합니다. 로컬 소스는 다음 버전을 Update에서 직접 골라야 합니다. `SHA256SUMS.txt`로 파일을 비교할 수 있습니다. 현재 MPP에는 배포자 서명이 없습니다.

## 다음 버전 릴리스

1. 수정 소스·변경 기록·검증 결과와 `scripts/build.py`의 VERSION 등 버전 표기를 main에 반영합니다. 새 버전에는 새 태그를 사용합니다.
2. Actions → Release → Run workflow에서 main을 선택합니다. Windows standalone 빌드가 정책·SQL 검사와 MPP 로딩을 수행합니다. 기존 npm semantic-release 설정은 사용하지 않습니다.
3. 같은 버전의 수정 소스와 MPP, LICENSE·NOTICE·THIRD_PARTY_NOTICES, 해시를 사전 릴리스에 함께 게시하고 main의 메타데이터를 갱신합니다.
4. 공개 파일과 패치 목록을 확인합니다. 앱 실행 코드가 바뀌었으면 실기기에서 알림 수신·읽음·후속 새 메시지를 다시 시험합니다.

LINE APK·APKM, 개인 서명키, 진단 로그·화면·DB는 공개 배포에서 제외합니다. 배포 채널은 GitHub이며 커뮤니티 인덱스에는 제출하지 않았습니다. 등재 없이도 저장소 주소로 추가할 수 있습니다.
