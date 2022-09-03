package section1.java_basic.if_else;

/*
isGreaterThan
문제
두 개의 수를 입력받아 두번째 수가 첫번째 수보다 큰지 여부를 리턴해야 합니다.

입력
인자 1 : num1
int 타입의 수
인자 2 : num2
int 타입의 수

출력
boolean 타입을 리턴해야 합니다.

주의 사항
같은 수를 입력받은 경우, false를 리턴해야 합니다

입출력 예시
boolean output = isGreaterThan(11, 10);
System.out.println(output); // --> false
*/

public class Q_04_isGreaterThan {
    public static void main(String[] args) {
        Q_04_isGreaterThan coplit = new Q_04_isGreaterThan();
        System.out.println(coplit.isGreaterThan(11, 10));

    }

    public boolean isGreaterThan(int num1, int num2) {
        // TODO:
        if (num1 < num2) {
            return true;
        }
        return false;
    }
}