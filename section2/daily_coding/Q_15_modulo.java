package section2.daily_coding;
/*
modulo
문제
두 수(num1, num2)를 입력받아, num1를 num2로 나눈 나머지를 리턴해야 합니다.

입력
인자 1 : num1
int 타입의 정수 (num1 >= 0)
인자 2 : num2
int 타입의 정수 (num2 >= 0)

출력
Integer 타입을 리턴해야 합니다.

주의 사항
나눗셈(/), 나머지(%) 연산자 사용은 금지됩니다.
0은 어떤 수로 나누어도 나머지가 0입니다.
어떤 수도 0으로 나눌 수 없습니다. 이 경우 null를 리턴해야 합니다.

입출력 예시
Integer output = modulo(25, 4);
System.out.println(output); // --> 1

output = modulo(25, 0);
System.out.println(output); // --> null
 */

public class Q_15_modulo {
    public static void main(String[] args) {
        // write test case here
        Q_15_modulo coplit = new Q_15_modulo();

        Integer output = coplit.modulo(25, 4);
        System.out.println(output); // --> 1

        output = coplit.modulo(25, 0);
        System.out.println(output); // --> null
    }

    public Integer modulo(int num1, int num2) {
        if (num2 == 0) return null;
        while (num1 >= num2){
            num1 -= num2;
        }
        return num1;
    }
}
