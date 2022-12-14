package section1.java_basic.array;

import java.util.Arrays;

/* 
fibonacci
문제
수(num)를 입력받아 num번째까지 총 num + 1개의 피보나치 수열을 리턴해야 합니다.

0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1입니다. 그 다음 2번째 피보나치 수부터는 바로 직전의 두 피보나치 수의 합으로 정의합니다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

입력
인자 1 : num
int 타입의 num (num은 0 이상의 정수)

출력
int 타입을 요소로 가지는 배열을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
피보나치 수열은 0번부터 시작합니다.

입출력 예시
int[] output = fibonacci(0);
System.out.println(output); // --> [0]

output = fibonacci(8);
System.out.println(output); // --> [0, 1, 1, 2, 3, 5, 8, 13, 21]
 */

public class Q_19_fibonacci {
    public static void main(String[] args) {
        Q_19_fibonacci coplit = new Q_19_fibonacci();
        System.out.println(Arrays.toString(coplit.fibonacci(0)));
        System.out.println(Arrays.toString(coplit.fibonacci(8)));
    }

    public int[] fibonacci(int num) {
        // TODO:
        int[] output = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i <= 1) {
                output[i] = i;
            } else {
                output[i] = output[i - 1] + output[i - 2];
            }
        }
        return output;
    }
}