package section1.java_basic.if_else;

/*
isEven
수를 입력받아 짝수인지 여부를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)

출력
boolean 타입을 리턴해야 합니다.

주의 사항
0은 짝수로 간주합니다.

입출력 예시
boolean output = isEven(11);
System.out.println(output); // --> false

힌트
짝수(even number)와 홀수(odd number)의 차이를 검색해 봅니다. (java check even number)
*/

public class Q_05_isEven {
    public static void main(String[] args) {
        Q_05_isEven coplit = new Q_05_isEven();
        System.out.println(coplit.isEven(11));

    }

    public boolean isEven(int num) {
        // TODO:
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}