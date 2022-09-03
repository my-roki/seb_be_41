package section1.java_basic.for_while;

/* 
makeMultiplesOfDigit2
문제
두 개의 수를 입력받아 두 수를 포함해 두 수 사이의 수 중 2의 배수의 개수를 리턴해야 합니다.

입력
인자 1 : num1
int 타입의 정수 (num1 >= 0)
인자 2 : num2
int 타입의 정수 (num2 >= 0)
출력
int 타입을 리턴해야 합니다.
주의 사항
반복문(for)문을 사용해야 합니다.
num1이 num2보다 작지 않을 수도 있습니다.
0은 2의 배수가 아니라고 가정합니다.
입출력 예시
int output = makeMultiplesOfDigit2(8, 12);
System.out.println(output); // --> 3

output = makeMultiplesOfDigit2(12, 8);
System.out.println(output); // --> 3

output = makeMultiplesOfDigit2(1, 3);
System.out.println(output); // --> 1

output = makeMultiplesOfDigit2(0, 0);
System.out.println(output); // --> 0

output = makeMultiplesOfDigit2(2, 2);
System.out.println(output); // --> 1
 */

public class Q_09_makeMultiplesOfDigit2 {
    public static void main(String[] args) {
        Q_09_makeMultiplesOfDigit2 coplit = new Q_09_makeMultiplesOfDigit2();
        System.out.println(coplit.makeMultiplesOfDigit2(0, 0));
        System.out.println(coplit.makeMultiplesOfDigit2(0, 1));
        System.out.println(coplit.makeMultiplesOfDigit2(1, 0));
        System.out.println(coplit.makeMultiplesOfDigit2(2, 10));
        System.out.println(coplit.makeMultiplesOfDigit2(9, 3));
        System.out.println(coplit.makeMultiplesOfDigit2(8, 8));
        System.out.println(coplit.makeMultiplesOfDigit2(0, 9));
        System.out.println(coplit.makeMultiplesOfDigit2(12, 0));
    }

    public int makeMultiplesOfDigit2(int num1, int num2) {
        // TODO:
        int big;
        int small;
        if (num1 > num2) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }

        int result = 0;
        for (int i = small; i <= big; i++) {
            if (i != 0 && i % 2 == 0)
                result += 1;
        }
        return result;

    }
}