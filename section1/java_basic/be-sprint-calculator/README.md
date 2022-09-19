# **계산기 만들기**

## **과제 준비하기**

[계산기 만들기 Repository](https://github.com/codestates-seb/be-sprint-calculator) 실습 과제를 `fork` 합니다. 터미널에서 `git clone` 명령어로 레포지토리를 클론합니다.
([Git 유닛](https://urclass.codestates.com/28b8dedb-908c-4cb6-883b-2cfa4ce02f4e?playlist=1977)을 참고해주세요.)

IntelliJ에서 Open 한 후 에러가 난다면, 오른쪽 상단의 `Setting SDK`를 클릭하여 Java 버전에 맞는 개발 환경을 세팅하고 과제를 진행합니다.

<img src="https://s3.ap-northeast-2.amazonaws.com/urclass-images/4RSHfmhOyS2hehkqR1pGZ-1651413481738.png" />

## **실습 목표**

### **Bare Minimum Requirement (최소 기능 구현)**

Bare Minimum Requirements는 소프트웨어가 그 역할을 하기에 필요한 최소한의 요구사항입니다. 소프트웨어의 프로토타입을 빠르게 만들고, 프로토타입을 두고 기획자, 디자이너와 함께 회의를 하고 유저 경험을 개선할 수 있습니다. 개발자도 프로토타입을 생성하고 공유하고, 테스트하는 과정에서 이 소프트웨어에서 생길 수 있는 오류를 좀 더 빠르게 예측할 수 있습니다.
**실습 과제를 제출할 때에는 Bare Minimum Requirements를 잘 마무리했는지 확인하고 제출해야 과제가 정상적으로 제출됩니다.**

`src` 폴더 내의 `main.java` 파일을 수정하여 사칙연산이 가능한 계산기를 구현합니다.

- 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
- 연산자의 종류는 +, -, \*, / 네 가지 입니다.
  - 연산자의 종류에 따라 조건을 분기합니다.
- 소수점 연산을 수행할 수 있어야 합니다.
- 연산 결과를 콘솔에 출력합니다.

### **Advanced Challenge (심화 기능 구현)**

> Advanced Challenges는 여러분이 필수적으로 해야 하는 과제는 아닙니다. 앞서 Bare Minimum Requirements를 달성하고, 시간이 남거나 더 깊은 공부가 필요할 때 도전할 수 있는 과제입니다.

- 여러 번의 입력을 받고, 입력받은 만큼 계산을 할 수 있어야 합니다.
  - 반복문을 통해 여러 번의 입력을 받을 수 있습니다.
- 사용자가 잘못된 값을 입력한 경우, 사용자에게 피드백을 줄 수 있습니다.
  - 예를 들어 사칙연산 연산자(+, -, \*, /)가 아닌 다른 기호가 들어온 경우, `잘못된 입력`이라는 피드백을 줄 수 있어야 합니다. (문구는 동일하지 않아도 괜찮습니다.)
