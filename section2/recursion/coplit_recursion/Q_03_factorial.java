package section2.recursion.coplit_recursion;

/*
factorial
문제
수를 입력받아 n-factorial(n!; 엔-팩토리얼) 값을 리턴해야 합니다.
n! 은 1부터 n까지 1씩 증가한 모든 값의 곱입니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)

출력
int 타입을 리턴해야 합니다.
1 * 2 * ... * num

주의 사항
함수 factorial은 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
factorial(0)은 1로 정의됩니다.
음수 입력은 들어오지 않습니다.

입출력 예시
int output = factorial(10);
System.out.println(output); // --> 3628800

힌트
factorial(n)은 자연수 1부터 n까지의 곱을 계산하는 함수입니다.
factorial(1) = 1
factorial(2) = 1 * 2 = 2
factorial(3) = 1 * 2 * 3 = 6
factorial(4) = 1 * 2 * 3 * 4 = 24
 */


public class Q_03_factorial {
    public static void main(String[] args) {
        // write test case here
        Q_03_factorial coplit = new Q_03_factorial();
        int output = coplit.factorial(10);
        System.out.println(output); // --> 3628800

    }

    public int factorial(int num){
        if (num == 0) return 1;

        int output = num * factorial(num-1);
        return output;
    }
}
