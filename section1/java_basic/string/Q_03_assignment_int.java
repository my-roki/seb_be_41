
package section1.java_basic.string;

/* 
변수에 값 할당하기(Assignment)
이전 문제에서 우리는 문자를 넣을 수 있는 변수를 선언하고, 정확한 문자를 할당했습니다. 문자가 아닌 정수를 넣을 수 있는 변수를 선언하고, 해당 변수에 정수를 넣어보도록 할까요?

int number; // number 변수 선언
number = 100; // number 변수에 정수 100 할당

문제
선언되어 있는 변수 num에 정수 100을 할당하세요.
 */

public class Q_03_assignment_int {
    public static void main(String[] args) {
        new Q_03_assignment_int().assignment();
    }

    int num;

    // TODO : 선언되어 있는 변수 num에 정수 100을 할당하세요.
    public void assignment() {
        // 코드는 아래 라인에 작성해야 합니다.
        num = 100;
    }
}