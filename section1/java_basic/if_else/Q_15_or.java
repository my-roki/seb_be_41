package section1.java_basic.if_else;

/*
or
문제
두 개의 boolean 값을 입력받아 or 연산을 적용한 것과 같은 결과를 리턴해야 합니다.

입력
인자 1 : expression1
boolean 타입의 값
인자 2 : expression2
boolean 타입의 값

출력
boolean 타입을 리턴해야 합니다.

주의 사항
|| 연산자 사용은 금지됩니다.

입출력 예시
boolean output = or(true, false);
System.out.println(output); // --> true;

힌트
&& 과 ! 연산자를 사용합니다.
*/

public class Q_15_or {
    public static void main(String[] args) {
        Q_15_or coplit = new Q_15_or();
        System.out.println(coplit.or(true, false));
    }

    public boolean or(boolean expression1, boolean expression2) {
        // TODO:
        if (!expression1 && !expression2) {
            return false;
        }
        return true;
    }
}