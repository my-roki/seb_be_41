package section1.java_basic.for_while;

/* 
factorial

문제
수를 입력받아 n-factorial(n!) 값을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)

출력
int 타입을 리턴해야 합니다.
1 * 2 * ... * num

주의 사항
반복문(for)문을 사용해야 합니다.
factorial(0)은 1로 정의됩니다.
음수 입력은 들어오지 않습니다.

입출력 예시
int output = factorial(5);
System.out.println(output); // --> 120
 */

public class Q_03factorial {
    public static void main(String[] args) {
        Q_03factorial coplit = new Q_03factorial();
        System.out.println(coplit.factorial(0));
        System.out.println(coplit.factorial(4));
        System.out.println(coplit.factorial(10));
    }

    public int factorial(int num) {
        int result = 1;
        // TODO :
        if (num == 0) {
            return 1;
        }

        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}