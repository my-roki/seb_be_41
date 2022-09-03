package section1.java_basic.if_else;

/*
입력
인자 1 : side1
int 타입의 삼각형 한 변 (1 이상의 정수)
인자 1 : side2
int 타입의 삼각형 한 변 (1 이상의 정수)
인자 1 : side3
int 타입의 삼각형 한 변 (1 이상의 정수)

출력
boolean 타입을 리턴해야 합니다.

주의 사항
삼각형의 각 세 변은 무작위로 입력됩니다.
arr.sort 사용은 금지됩니다.
제곱을 구할 때는 입력으로 주어지는 변수를 그대로 사용해야 합니다.

입출력 예시
boolean output = isPythagorean(3, 4, 5);
System.out.println(output); // --> true (5 * 5 = 3 * 3 + 4 * 4)

output = isPythagorean(5, 3, 4);
System.out.println(output); // --> true

output = isPythagorean(6, 4, 5);
System.out.println(output); // --> false

힌트
직각삼각형은 가장 큰 변(빗변)의 제곱이 나머지 두 변 각각의 제곱의 합과 동일합니다. (피타고라스의 정리)
수학에서 자주 사용하는 상수(constants)와 함수들을 미리 구현해 놓은 자바 표준 내장 객체가 있습니다.
Math 객체를 검색해 봅니다. (java math 또는 자바 math method)
자바에서의 거듭제곱 연산을 직접 검색해 봅니다. (java how to power 또는 자바 거듭제곱)
*/

public class Q_14_isPythagorean {
    public static void main(String[] args) {
        Q_14_isPythagorean coplit = new Q_14_isPythagorean();
        System.out.println(coplit.isPythagorean(3, 4, 5));
        System.out.println(coplit.isPythagorean(5, 3, 4));
        System.out.println(coplit.isPythagorean(6, 4, 5));

    }

    public boolean isPythagorean(int side1, int side2, int side3) {
        // TODO:
        // 3개의 크기를 순서대로 나열한다.
        // 각 변을 제곱한다.
        int jaegop1 = side1 * side1;
        int jaegop2 = side2 * side2;
        int jaegop3 = side3 * side3;

        // 피타고라스 정리를 통해 직각삼각형 여부를 판별한다.
        if (jaegop1 == jaegop2 + jaegop3 || jaegop2 == jaegop1 + jaegop3 || jaegop3 == jaegop2 + jaegop1) {
            return true;
        }
        return false;
    }
}