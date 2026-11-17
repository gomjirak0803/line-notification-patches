# Morphe에서 사용·공개하는 방법

확인일: 2026-11-17. 이 프로젝트는 독립된 커뮤니티 패치입니다. 현재 0.1.8-dev의 기기 시험 기록과 [공개 전 검토](PUBLICATION_AUDIT.md)를 함께 제공하세요.

## 내 기기에 가져오기

휴대폰의 `Download/LINE-notification-test/line-notification-patches-0.1.8-dev.mpp`를 사용합니다. Morphe Manager에서 **Sources → + → Local**을 열고 해당 파일을 선택합니다. 기존 로컬 소스가 있으면 Update에서 새 파일을 선택할 수 있습니다. 이 방식은 자동 갱신되지 않습니다. 원본 LINE 26.16.0 APKM 전체를 선택하고 Expert mode 및 해당 소스의 Experimental app versions를 켭니다. 세부 패치·설정 방법은 README에 있습니다. [공식 Manager 소스 안내](https://github.com/MorpheApp/morphe-manager/blob/main/docs/patch-sources.md)

## 다른 사람에게 파일로 배포

`.mpp`와 **같은 버전의 수정 소스 ZIP**, LICENSE, NOTICE, THIRD_PARTY_NOTICES, 설치·제한 안내와 SHA-256을 같은 배포 위치에서 제공합니다. 원본 프로젝트 링크만 적고 수정 소스를 생략하지 마세요. 현재 기기의 시험용 전체 LINE APK, 원본 APKM, `.tools/signing`, 로그·화면 캡처·DB는 공개 파일에서 제외합니다.

`artifacts/release-review/0.1.8-dev/`는 실기기 시험한 최종 패치와 대응 소스·고지를 모은 로컬 검토 자료입니다. 0.1.7 검토 ZIP은 수정 전 기록으로 보존합니다. 어느 폴더도 공개 서버에 업로드된 것은 아닙니다.

## GitHub 저장소를 원격 소스로 배포

1. 본인 소유 공개 저장소를 만들고 독립적인 이름을 정합니다. 예: `line-notification-patches`. 원격 주소는 아직 템플릿이므로 이를 그대로 push하지 않습니다. 설정의 author·source·website·contact와 이슈 링크를 본인 저장소에 맞춥니다.
2. 대응 소스·LICENSE·NOTICE·출처 고지·문서를 커밋합니다. 원본 앱·진단 자료·키는 제외합니다. 처음 소스를 올릴 때는 자동 Actions 실행을 비활성화하고, 아래 릴리스 경로를 먼저 연결합니다.
3. 공식 템플릿의 **기존** `release.yml`과 `.releaserc`를 프로젝트에 맞춥니다. 현재 검증된 것은 Windows standalone 빌드이며, 템플릿 자동 배포의 Gradle·버전·산출물 이름 연결은 아직 검증하지 않았습니다. 새 릴리스 스크립트를 겹쳐 놓기보다 기존 경로를 정리합니다. 템플릿 방식은 dev의 semantic commit으로 사전 릴리스를 만들고 main으로 병합해 정식 릴리스를 만듭니다. [공식 템플릿 설명](https://github.com/MorpheApp/morphe-patches-template#readme)
4. workflow가 실제 `.mpp`, 같은 버전 소스, `patches-bundle.json`, `patches-list.json`과 해시를 올바르게 생성하는지 확인합니다. 지금 저장소의 JSON은 빈 템플릿이라 사용할 수 없습니다. 생성되는 파일을 직접 편집해 자동화와 충돌시키지 마세요. 불완전한 메타데이터를 둔 채 수동 Release 파일만 올리면 원격 갱신이 완성되지 않습니다.
5. 선택형 배포 서명은 템플릿의 `generateSigningKey`와 `MORPHE_SIGNING_KEY` 절차를 사용합니다. 공개키만 공개하고 개인키는 저장소 밖에 보관합니다. 기존 LINE 시험 APK 서명 p12를 업로드하거나 이 용도로 재사용하지 않습니다.
6. 공개 전 별도 Manager에서 **Sources → + → Remote → 본인 GitHub 저장소 주소**로 로딩·버전·패치 목록·원본 APKM 적용을 확인합니다. Patcher 2.3.0을 지원하는 Manager가 필요하며 사전 릴리스·실험 앱 대상 설정도 확인합니다.
7. 사용자가 추가할 주소는 `https://github.com/OWNER/REPO`이며, 공유 링크는 `https://morphe.software/add-source?github=OWNER/REPO` 형식입니다. OWNER/REPO는 실제 공개한 저장소로 바꿉니다. 이 주소는 현재 프로젝트에 대해 아직 만들어지지 않았습니다.

## 커뮤니티 목록에 노출

원격 저장소·릴리스가 정상 작동한 뒤 [Morphe Community Patches](https://morphe-patches.software/)의 **Submit a bundle**에서 공개 GitHub/GitLab 저장소 주소를 제출합니다. 폼에는 Repository URL과 선택적인 이메일·메모가 있습니다. APK를 업로드하는 폼이 아닙니다. 커뮤니티의 목록 등재와 공식 제작·보안 검증은 서로 다른 의미입니다.

공식 기본 패치 저장소는 현재 YouTube·YT Music·Reddit의 수정/개선 PR을 받으며, 그 외 앱은 독립 저장소 배포를 안내합니다. LINE은 위 커뮤니티 경로가 맞습니다. [공식 기여 정책](https://github.com/MorpheApp/morphe-patches#contributing)

## 공개 설명에 포함할 사실

- LINE 26.16.0/versionCode 261600106과 검증한 두 입력만 지원하며 다른 구조에서는 중단할 수 있습니다. 원본 APKM 해시는 COMPATIBILITY.md에 있습니다.
- Morphe용 실험 패치이며 공식 LINE·Morphe·카카오톡과 무관합니다. GPL 수정 재사용 출처를 유지합니다.
- 현재 기기 검증은 S10e Android 12 중심입니다. 전체 미검증 사례는 DEVICE_TESTS.md에 남아 있습니다.
- Restore push registration은 재서명 후 Firebase 등록의 인증서 식별값을 바꾸는 선택형 호환 처리입니다. 계정 정지 위험이 없다고 홍보하지 않습니다.
- 기능은 최초 꺼짐이며 읽음 버튼은 방 전체를 읽음 처리합니다. 기존 서버 무음 방은 켜기→끄기 전환이 필요할 수 있습니다.
