package section1.java_basic.for_while;

/* 
computePower

문제
밑(base)과 지수(exponent)를 입력받아 밑의 거듭제곱을 리턴해야 합니다.

입력
인자 1 : base
int 타입의 밑
인자 2 : exponent
int 타입의 지수

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
Math.pow, 거듭제곱 연산자 사용은 금지됩니다. (거듭제곱은 자바에서 제공하는 Math를 통해 쉽게 구할 수 있습니다.)

입출력 예시
int output = computePower(2, 3);
System.out.println(output); // --> 8
 */

public class Q_15_computePower {
    public static void main(String[] args) {
        Q_15_computePower coplit = new Q_15_computePower();
        System.out.println(coplit.computePower(2, 3));
    }

    public int computePower(int base, int exponent) {
        // TODO:
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}