# 공개 상태 — 2026-11-20

## 최신 릴리스 (`v0.1.10-dev`)

- 저장소: https://github.com/gomjirak0803/line-notification-patches
- 릴리스: https://github.com/gomjirak0803/line-notification-patches/releases/tag/v0.1.10-dev
- Manager 추가: https://morphe.software/add-source?github=gomjirak0803/line-notification-patches
- 빌드 실행: https://github.com/gomjirak0803/line-notification-patches/actions/runs/44716250040 (성공, 1m4s)
- 릴리스 소스 커밋: `5212f2f6258828ad1e789e123ad75b1b7df77429` (메타데이터 갱신 커밋: `38a6376`)

공개 MPP의 SHA-256은 `29e2bad20b46db8b731b928cfde5096c1dbd9de202d25655d792389454a4a186`이며 125,636바이트입니다. `SHA256SUMS.txt`·직접 내려받은 파일 해시가 일치했고, S10e 실기기 시험본 `126d6d972ecf75f4dd439197c78c472b5739f23cad21f5fcf9af2351c3219453`과 ZIP 항목별(17개) 대조 결과 실행 클래스·DEX·확장·Manifest는 모두 동일하며 차이는 `THIRD_PARTY_NOTICES.md` 줄바꿈(CRLF/LF)뿐입니다. 같은 버전 소스 ZIP의 SHA-256은 `9e519a465954b6dc6cff4e8e03181d8355fc4571c470f45dc587a1fe1b83ffd5`입니다. `main/patches-bundle.json`은 `"created_at": "2026-11-20T10:06:33"`, `"version": "0.1.10-dev"`로 갱신됐으며 `tests/test_bundle_metadata.py` 3개 검사를 통과했습니다.

## 이전 릴리스 기록 (`v0.1.9-dev`, 2026-11-20)

- 저장소: https://github.com/gomjirak0803/line-notification-patches
- 릴리스: https://github.com/gomjirak0803/line-notification-patches/releases/tag/v0.1.9-dev
- Manager 추가: https://morphe.software/add-source?github=gomjirak0803/line-notification-patches
- 빌드 실행: https://github.com/gomjirak0803/line-notification-patches/actions/runs/44698544166 (성공, 1m3s)
- 릴리스 소스 커밋: `950a9d4ea3dedbcdf3d22610ac8b0446b79dd399` (메타데이터 갱신 커밋: `131990a`)

공개 MPP의 SHA-256은 `45cd8e71747a67552e21ef9b0782107cc50da2db35f791efdf7f2adaf9cfdbcb`이며 131,929바이트입니다. GitHub API의 asset digest·`SHA256SUMS.txt`·직접 내려받은 파일 해시가 일치했습니다. S10e 실기기 시험본 `7d34bdd0f028b728f315919692e8a2eb9dc5c6c4197f7c338b23dd874bf2d401`과 ZIP 항목별(18개)로 비교한 결과, 실행 클래스·DEX·확장·Manifest·리소스는 모두 동일하며 차이는 `THIRD_PARTY_NOTICES.md`의 줄바꿈(CRLF/LF)뿐입니다. 같은 버전 소스 ZIP의 SHA-256은 `dd49cb237dc064a2c14c5c22cb9f0e02d425a80a01c64eb4d3b55ec6ed15cde3`입니다.

S10e의 Morphe Manager `2.6.0`에서 기존 원격 소스(`0.1.8-dev`)의 `업데이트`를 눌러 **`0.1.8-dev → 0.1.9-dev` 원격 자동 업데이트**가 `main/patches-bundle.json`(`"created_at": "2026-11-20T07:56:27"`) 파싱 → GitHub Releases `line-notification-patches-0.1.9-dev.mpp` 다운로드 → 버전 `0.1.9-dev` 반영까지 오류 없이 완료됨을 확인했습니다.

## 이전 릴리스 기록 (`v0.1.8-dev`, 2026-11-18)

- 저장소: https://github.com/gomjirak0803/line-notification-patches
- 릴리스: https://github.com/gomjirak0803/line-notification-patches/releases/tag/v0.1.8-dev
- Manager 추가: https://morphe.software/add-source?github=gomjirak0803/line-notification-patches
- 빌드 실행: https://github.com/gomjirak0803/line-notification-patches/actions/runs/44096981707 (성공)
- 릴리스 소스 커밋: `41d58b1fc62190af00a532223296c0a362da4a3a`

공개 MPP의 SHA-256은 `45233180b1accc88e4ad0f37bc643a60db9a6792df9a5d5b83e21dfeca146a85`이며 127,693바이트입니다. GitHub API의 asset digest와 직접 내려받은 파일의 해시가 일치했습니다. 실기기 시험본 `9fcb3100f2e09933c8ac48226d7fb88ebf42cf8b13cbc15d786c9cf3ef39a168`과 ZIP 항목별로 비교했으며, 실행 클래스·DEX·Manifest·리소스는 모두 같습니다. 차이는 THIRD_PARTY_NOTICES.md의 줄바꿈뿐입니다. 같은 버전 소스 ZIP의 SHA-256은 `5a5b03cebe4b71232ec4c72cb21eb37e71f45a4ba35ffc9cecc95a05b4adcee1`입니다.

릴리스에는 MPP, 대응 소스 ZIP, LICENSE, NOTICE, THIRD_PARTY_NOTICES.md, 패치 목록·원격 메타데이터, SHA256SUMS.txt를 올렸습니다. 원본/패치된 LINE APK·APKM, 개인키, 계정 DB, 기기 로그·대화 화면은 공개 파일에서 제외했습니다. MPP 배포자 서명은 아직 없으며 SHA-256은 무결성 비교용입니다.

Morphe Desktop 2.1.1 / Patcher 2.3.0에서 공개 저장소 주소와 `--prerelease -x`로 실제 다운로드·패치 6개 로딩에 성공했습니다. Desktop은 dev 쪽의 JSON이 없을 때 GitHub Releases API로 사전 릴리스를 가져왔습니다. main의 공개 JSON과 패치 6개 목록도 확인했습니다. Manager에서는 Pre-release patches와 Experimental app versions를 켜세요.

## Android Morphe Manager 2.6.0 실기기 검증 — 2026-11-20

Galaxy S10e(SM-G970N, Android 12/API 31)에 설치된 `app.morphe.manager` `2.6.0` (`versionCode 39922687`)으로 실제 원격 추가와 로컬 적용을 시험했습니다. 기존 설치된 LINE(`lastUpdateTime 2026-11-17 22:31:21`)은 덮어쓰지 않고 보존했습니다.

1. **원격 소스 추가 실패 원인 확인 및 수정 완료 (`2da3dba6`)**:
   - `https://github.com/gomjirak0803/line-notification-patches`를 원격 소스로 추가하면 Manager는 `https://raw.githubusercontent.com/gomjirak0803/line-notification-patches/main/patches-bundle.json`으로 변환해 조회합니다. `Pre-release 패치`가 켜져 있으면 `dev/patches-bundle.json`도 함께 조회하며, 현재 `dev` 브랜치가 없어 404가 발생합니다.
   - Morphe Desktop과 달리 **Morphe Manager 2.6.0은 GitHub Releases API로 폴백하지 않으며**, 기존 `main/patches-bundle.json`의 `created_at` 값(`2026-11-17T13:52:42.238676+00:00`)을 `java.time.LocalDateTime.parse`로 파싱하는 `LocalDateTimeSerializer`에서 `+00:00` 오프셋(index 26) 때문에 `DateTimeParseException` / `JsonDecodingException`이 발생했습니다. 그 결과 수정 전에는 `Pre-release 패치` 켜짐·꺼짐 모두 `이름 없음 / 메타데이터 없음`(`패치 0`, `버전 N/A`)으로 실패했습니다.
   - 공식 `MorpheApp/morphe-patches` 형식(`YYYY-MM-DDTHH:MM:SS`)에 맞춰 `scripts/prepare_release.py`와 `patches-bundle.json`을 `strftime("%Y-%m-%dT%H:%M:%S")`로 수정하고 회귀 테스트(`tests/test_bundle_metadata.py`)를 추가해 `main`에 반영(`2da3dba6c9238bcfdcea1683a3cdcea713f93d3d`)했습니다.
   - 반영 직후 S10e Morphe Manager 2.6.0에서 원격 소스 업데이트를 재시험한 결과, **`Pre-release 패치` 꺼짐·켜짐 모두** GitHub Releases의 `line-notification-patches-0.1.8-dev.mpp` 다운로드 및 `LINE notification patches` (`0.1.8-dev`, 패치 6개, 앱 1개) 인식에 성공했습니다(`Pre-release` 켜짐 시 `dev/patches-bundle.json` 404 뒤 유효한 `main/patches-bundle.json`을 사용). 로컬 복사본 소스를 제거한 뒤에도 원격 소스만으로 홈 화면에 `LINE` (`26.16.0` / `261600106`, 권장·실험 버전)이 오류 배너 없이 정상 표시됨을 확인했습니다.
2. **26.16.0 APKM 실기기 패치 성공**:
   - `설정 → 전문가 모드`와 `실험 앱 버전`을 켠 뒤 원본 ARM64 APKM(`26.16.0` / `261600106`)을 선택해 6개 패치 전체를 적용했습니다. 분할 APK 4개 병합, 6개 패치 모두 성공, 리소스 재컴파일 및 서명까지 총 28.5초(`output.apk` 221,809,392바이트)로 오류 없이 완료됐습니다. 설치 단계는 실행하지 않았습니다.

커뮤니티 인덱스 등록 요청은 **제출하지 않았습니다**. 사용자가 GitHub 배포만 유지하도록 선택했습니다. GitHub 저장소와 직접 추가 링크는 인덱스 등재 없이 사용할 수 있습니다.
