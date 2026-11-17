# 본인에게 LINE 테스트 메시지 보내기

2026-11-17 공식 문서를 확인했습니다. **공식 계정 생성 → Messaging API 활성화 → 본인 친구 추가 → PC 도구에서 발송** 순서입니다. 본인 User ID를 개발자 화면에서 가져와 단방향 push만 보내므로 웹훅 서버·공개 URL·Channel secret은 필요하지 않습니다. LINE 앱 패치·설치 APK에는 이 도구가 들어가지 않습니다.

## 1. 공식 계정 만들기

[LINE Official Account Manager](https://manager.line.biz/)에서 로그인하고 공식 계정을 생성합니다. Business ID가 없으면 먼저 등록하며, 수신에 쓸 본인 LINE과 연결된 계정을 사용하면 이후 Your user ID 확인이 쉽습니다. 계정 이름은 `LINE 알림 테스트`처럼 알아보기 쉽게 정합니다. 등록 화면의 필수 정보는 본인 정보로 입력합니다. [공식 생성 안내](https://developers.line.biz/en/docs/messaging-api/getting-started/)

## 2. Messaging API 활성화

만든 공식 계정의 웹 관리 화면에서 **Settings(설정) → Messaging API → Enable/Use Messaging API**를 선택합니다. 본인 테스트용 provider를 만들거나 선택합니다. 선택한 provider는 나중에 바꿀 수 없으므로 회사·타인의 provider를 고르지 않습니다. 활성화하면 Messaging API channel이 생성됩니다. Developers Console에서 채널을 직접 새로 만드는 예전 절차가 아닙니다. [공식 설정 안내](https://www.lycbiz.com/jp/manual/OfficialAccountManager/account-settings_messaging_api/)

## 3. 친구 추가·토큰 준비

[LINE Developers Console](https://developers.line.biz/console/)에 같은 계정으로 로그인합니다. 생성한 provider → Messaging API channel을 엽니다.

- **Messaging API** 탭의 QR 코드를 휴대폰 LINE으로 스캔해 테스트 공식 계정을 친구 추가합니다.
- 같은 탭의 **Channel access token (long-lived)**에서 **Issue**로 테스트용 토큰을 발급합니다. 이미 있는 계정의 토큰을 재발급하면 기존 연동에 영향을 줄 수 있으므로 새 테스트 계정을 사용합니다.
- **Basic settings → Your user ID**를 확인합니다. `U`로 시작하는 33자리이며 친구 검색용 LINE ID와 다릅니다. 안 보이면 Business ID와 본인 LINE 계정 연결을 확인합니다.

토큰과 User ID는 채팅·공개 저장소에 붙이지 않고 아래 로컬 도구에 직접 입력합니다. 이 도구는 두 값을 파일에 저장하지 않습니다. [친구 추가 안내](https://developers.line.biz/en/docs/messaging-api/building-bot/), [토큰 안내](https://developers.line.biz/en/docs/basics/channel-access-token/#long-lived-channel-access-token), [본인 User ID 확인](https://developers.line.biz/en/docs/messaging-api/getting-user-ids/#developer-gets-their-own-user-id)

## 4. PC 발송 도구 실행

프로젝트 루트의 **LINE-test-sender.bat**를 더블클릭합니다. Python과 Tkinter가 필요하며 현재 작업 PC에는 둘 다 있습니다. 다음 명령으로 실행해도 됩니다.

```powershell
python scripts/line_test_sender.py
```

1. 토큰·Your user ID를 각 칸에 입력합니다.
2. 처음에는 **1개**, 시작 대기 **10초**로 설정합니다.
3. ‘테스트 메시지 보내기’를 누른 뒤, 휴대폰의 LINE을 배경으로 둡니다.
4. 공식 계정에서 알림이 도착하는지 확인합니다.
5. 해당 방을 읽어 기존 미확인 메시지를 비운 뒤 2개·26개, 긴 글·줄바꿈·혼합 유형을 시험합니다. 이후 알림을 관찰하는 동안에는 방을 다시 열지 않습니다.

‘최대 5개씩 묶음’은 한 요청에 최대 5개를 보내 API 요청 수를 줄입니다. 26개면 6회입니다. ‘한 개씩 순차 발송’은 알림 갱신 관찰용이며 26개면 26회 요청합니다. 공식 계정의 발송 한도가 사용되므로 지역·요금제의 한도를 확인하세요. 테스트 문자 수와 API 과금/한도 계산 단위는 같지 않을 수 있습니다. [메시지 발송·집계 설명](https://developers.line.biz/en/docs/messaging-api/sending-messages/)

중단은 다음 요청부터 막으며 이미 접수한 메시지는 취소하지 않습니다. 연결 확인 실패 때는 자동 재전송하지 않습니다. **API 접수 완료는 휴대폰 도착 확인이 아니므로** 알림과 미확인 숫자는 기기에서 직접 확인합니다. 공식 계정 방이 패치의 지원 경로인지도 첫 수신에서 확인해야 합니다. 일반 사용자 간 방·여러 발신자·그룹·직접 답장 검증은 별도로 남습니다.

## 검증 상태

이 도구는 실제 자격 증명 없이 오프라인 8개 검사를 통과했습니다. 26개 묶음·순서, 잘못된 수신자와 헤더 입력 거부, 오류 시 비밀 숨김·자동 재전송 금지, 리디렉션 차단·발송 전 취소를 확인했습니다. 이후 사용자가 준비한 공식 계정으로 실제 1개·2개·26개 발송과 수신을 확인했습니다. 토큰을 읽거나 저장하지 않고 사용자가 입력한 창의 발송 버튼을 사용했습니다.

26개 묶음 수신은 패치의 서버 ID 우선 선택 오류를 드러냈으며, 0.1.8에서 생성 시각 우선으로 수정합니다. 공식 계정에서 여러 문자를 묶어 보낼 때 서버 ID의 크기가 본문 번호·생성 시각 순서와 같다고 가정하지 마세요. 시험 결과는 DEVICE_TESTS.md에 버전별로 구분합니다.

```powershell
python -m unittest discover -s tests -p test_line_test_sender.py -v
python scripts/line_test_sender.py --dry-run --count 26 --kind mixed
```
