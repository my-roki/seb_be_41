package section1.java_basic.for_while;

/* 
isOdd

문제
수를 입력받아 홀수인지 여부를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수

출력
boolean 타입을 리턴해야 합니다.

주의 사항
반복문(while)문을 사용해야 합니다.
for문 사용은 금지됩니다.
나눗셈(/), 나머지(%) 연산자 사용은 금지됩니다.
0은 짝수로 간주합니다.

입출력 예시
boolean output = isOdd(17);
System.out.println(output); // --> true

output = isOdd(-8);
System.out.println(output); // --> false
 */

public class Q_02_isOdd {
    public static void main(String[] args) {
        Q_02_isOdd coplit = new Q_02_isOdd();
        System.out.println(coplit.isOdd(77));
        System.out.println(coplit.isOdd(100));
        System.out.println(coplit.isOdd(0));
        System.out.println(coplit.isOdd(-17));
    }

    public boolean isOdd(int num) {
        // 조건문을 사용하여 짝수인 경우 return false를,
        // 홀수인 경우 return true;를 작성해야 합니다.
        // TODO :
        while (true) {
            if (num == 1 || num == -1)
                return true;
            if (num == 0)
                return false;

            if (num > 0) {
                num -= 2;
            } else {
                num += 2;
            }
        }

    }
}