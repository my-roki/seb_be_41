package section2.recursion.coplit_recursion;

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
함수 isOdd는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
나눗셈(/), 나머지(%) 연산자 사용은 금지됩니다.
0은 짝수로 간주합니다.

입출력 예시
int output = isOdd(17);
system.out.println(output); // --> true

output = isOdd(-8);
system.out.println(output); // --> false
 */


public class Q_02_isOdd {
    public static void main(String[] args) {
        // write test case here
        Q_02_isOdd coplit = new Q_02_isOdd();
        boolean output = coplit.isOdd(17);
        System.out.println(output); // --> true

        output = coplit.isOdd(-8);
        System.out.println(output); // --> false
    }

    public boolean isOdd(int num) {
        if (num == 0) return false;
        if (num == 1 || num == -1) return true;

        if (num < 0) return isOdd(num + 2);
        else return isOdd(num - 2);
    }
}