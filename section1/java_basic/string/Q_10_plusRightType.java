
package section1.java_basic.string;

/* 
타입에 따른 작동 방식의 차이
우리는 직전 문제에서 ''따옴표로 감싸진 문자 타입과 우리가 평소에 사용하는 정수타입에 대해서 배웠습니다. 
우리가 보기엔 같은 숫자여도 따옴표의 유무에 따라 타입이 바뀌게 됩니다. 
자바는 타입이 고정되어있고 타입별로 연산을 진행해야하고 그에 맞지 않게 작성하면 에러가 나거나, 예상하지 못한 결과가 나옵니다.

int number1 = 1 + '1'; // 숫자 50
char number2 = 1 + '1'; // 문자 2
1 + 1을 기대하고 작성했지만 변수의 타입에 따라 정수 타입 변수엔 리터럴 정수 50, 문자 타입 변수엔 문자 2가 저장되었습니다. 왜 이렇게 되는걸까요?
먼저 문자형 타입이 아스키 코드에 의해 숫자로 바뀌어 연산을 진행합니다. 이후 변수의 타입에 맞게 타입이 변환되어 저장됩니다. 
이를 막기 위해서는, 각 타입에 맞는 문법을 사용해야 합니다. 우선 우리 점수부터 바로 고쳐볼까요?

문제
score에 숫자 100이 할당되도록 하기 코드를 수정하세요.
 */

public class Q_10_plusRightType {
    public static void main(String[] args) {
        Q_10_plusRightType coplit = new Q_10_plusRightType();
        System.out.println(coplit.plusRightType());
    }

    public int plusRightType() {
        int score = 99 + 1;

        return score;
    }
}