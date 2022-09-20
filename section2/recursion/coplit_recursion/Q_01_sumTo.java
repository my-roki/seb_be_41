package section2.recursion.coplit_recursion;

/*
sumTo
문제
수(num)를 입력받아 1부터 num까지의 합을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)

출력
int 타입을 리턴해야 합니다.
1 + 2 + ... + num

주의 사항
함수 sumTo는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
n * (n + 1) / 2 와 같은 공식의 사용은 금지됩니다.
음수 입력은 들어오지 않습니다.

입출력 예시
int output = sumTo(10);
system.out.println(output); // --> 55

힌트
sumTo(n)은 자연수 1부터 n까지의 합을 계산하는 함수입니다.
sumTo(1) = 1
sumTo(2) = 1 + 2 = 3
sumTo(3) = 1 + 2 + 3 = 6
sumTo(4) = 1 + 2 + 3 + 4 = 10
 */


public class Q_01_sumTo {
    public static void main(String[] args) {
        // write test case here
        Q_01_sumTo coplit = new Q_01_sumTo();
        int output = coplit.sumTo(10);
        System.out.println(output); // --> 55

    }

    public int sumTo(int num) {
        if (num == 0) return 0;
        int output = num + sumTo(num - 1);
        return output;
    }
}
