
package section1.java_basic.string;

/* 
값의 표현(expression)
표현식(expression)은 하나의 값으로 표현되는 코드를 의미합니다. 
우리는 수학에서 1 + 1이 무엇을 의미하는지 굳이 확인하지 않아도 잘 알고 있습니다. 2를 표현 하고 있습니다. 
자바에서도 이러한 글자, 숫자, 기호를 한 글자씩 "독해"하여 하나의 값으로 컴파일(compile)합니다. 아래 그림과 같은 과정으로 실행됩니다.

표현식은 변수로 구성되기도 합니다. 중학교 수학 시간에 배운 거속시라는 말이 기억이 나실지 모르겠습니다. (저만..?) 
우리가 speed와 distance를 알고 있다면, time을 구할 수 있습니다. 한시간에 5km를 달리는 Runcat이 10km를 가기 위해서는? 2시간이 걸릴 것입니다. 
다만 자연어를 이해하지 못하는 자바가 이를 계산하기 위해서는 아래와 같은 코드가 필요합니다.

int speed, distance, time;
speed = 5;
distance = 10;
time = distance / speed; // speed와 distance의 값을 조회하여, `/` 연산자와 함께 컴파일 한다!

좋아요 ! 이제 비슷한 문제를 한 번 풀어볼까요?

문제
변수 num1에 숫자 5를 할당하고, 변수 num2에 숫자 7을 할당한 후, 변수 result에 숫자 num1과 숫자 num2의 곱을 할당합니다.
 */

public class Q_05_expression {
    public static void main(String[] args) {
        new Q_05_expression().expression();
    }

    int num1, num2, result;
    // 변수 num1에 숫자 5를 할당하고, 변수 num2에 숫자 7을 할당한 후, 변수 result에 숫자가 할당된 변수 num1과 num2의
    // 곱을 할당합니다.

    public void expression() {
        // 코드는 아래 라인에 작성해야 합니다.
        // 곱을 할당합니다.
        num1 = 5;
        num2 = 7;
        result = num1 * num2;
    }
}
