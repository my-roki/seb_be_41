package section1.java_basic.if_else;

/*
isEvenAndGreaterThanTen

문제
수를 입력받아 입력된 수가 10보다 크고 짝수인지 여부를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 자연수 (num > 0)

출력
boolean 타입을 리턴해야 합니다.

주의 사항
10을 입력받은 경우, false를 리턴해야 합니다.

입출력 예시
boolean output = isEvenAndGreaterThanTen(13);
System.out.println(output); // --> false

힌트
여러 가지 조건을 동시에 판별하기 위해서는 논리 연산자를 학습해야 합니다. (java logical operator 또는 자바 논리 연산자)
*/

public class Q_06_isEvenAndGreaterThanTen {
    public static void main(String[] args) {
        Q_06_isEvenAndGreaterThanTen coplit = new Q_06_isEvenAndGreaterThanTen();
        System.out.println(coplit.isEvenAndGreaterThanTen(13));

    }

    public boolean isEvenAndGreaterThanTen(int num) {
        // TODO:
        if (num % 2 == 0 && num > 10) {
            return true;
        }
        return false;
    }
}