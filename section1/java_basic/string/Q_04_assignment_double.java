
package section1.java_basic.string;

/* 
변수에 값 할당하기(Assignment)
이전 문제에서 우리는 문자를 넣을 수 있는 변수를 선언하고, 정확한 문자를 할당했습니다. 문자가 아닌 실수를 넣을 수 있는 변수를 선언하고, 해당 변수에 실수를 넣어보도록 할까요?

double number; // number 변수 선언
number = 1.234; // number 변수에 실수 1.234 할당

문제
선언되어 있는 변수 pi에 실수 3.14를 할당하세요.
선언되어 있는 변수 num에 정수 100을 할당하세요.
 */

public class Q_04_assignment_double {
    public static void main(String[] args) {
        new Q_04_assignment_double().assignment();
    }

    double pi;

    // TODO : 선언되어 있는 변수 pi에 실수 3.14를 할당하세요.
    public void assignment() {
        // 코드는 아래 라인에 작성해야 합니다.
        pi = 3.14;
    }
}