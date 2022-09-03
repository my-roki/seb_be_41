package section1.java_basic.if_else;

/*
miniCalculator

문제
두 개의 수와 기호를 입력받아 알맞게 계산한 값을 리턴해야 합니다.

입력
인자 1 : num1
int 타입의 정수
인자 2 : num2
int 타입의 정수
인자 3 : operator
char 타입의 기호 ('+', '-', '*', '/', '%')

출력
int 타입을 리턴해야 합니다.

주의사항
정해지지 않은 기호를 입력받았을때는 항상 0을 리턴합니다.

입출력 예시
int output = miniCalculator(3, 4, '+');
System.out.println(output); // --> 7

output = miniCalculator(9, 3, '/');
System.out.println(output); // --> 3

output = miniCalculator(9, 3, '%');
System.out.println(output); // --> 0
*/

public class Q_08_miniCalculator {
    public static void main(String[] args) {
        Q_08_miniCalculator coplit = new Q_08_miniCalculator();
        System.out.println(coplit.miniCalculator(3, 4, '+'));
        System.out.println(coplit.miniCalculator(9, 3, '/'));
        System.out.println(coplit.miniCalculator(9, 3, '%'));

    }

    public int miniCalculator(int num1, int num2, char operator) {
        // TODO:
        if (operator == '+') {
            return num1 + num2;
        }
        if (operator == '-') {
            return num1 - num2;
        }
        if (operator == '*') {
            return num1 * num2;
        }
        if (operator == '/') {
            return num1 / num2;
        }
        if (operator == '%') {
            return num1 % num2;
        }
        return 0;
    }
}