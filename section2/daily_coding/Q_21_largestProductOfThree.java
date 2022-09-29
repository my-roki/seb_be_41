package section2.daily_coding;

/*
largestProductOfThree

문제
정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 임의의 배열

출력
int 타입을 리턴해야 합니다.

주의사항
입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
배열의 요소는 음수와 0을 포함하는 정수입니다.
배열의 길이는 3 이상입니다.

입출력 예시
int output = largestProductOfThree(new int[]{2, 1, 3, 7});
System.out.println(output); // --> 42 (= 2 * 3 * 7)

output = largestProductOfThree(new int[]{-1, 2, -5, 7});
System.out.println(output); // --> 35 (= -1 * -5 * 7)
 */

import java.util.Arrays;

public class Q_21_largestProductOfThree {
    public static void main(String[] args) {
        // write test case here
        Q_21_largestProductOfThree coplit = new Q_21_largestProductOfThree();

        int output = coplit.largestProductOfThree(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = coplit.largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)
    }

    public int largestProductOfThree(int[] arr) {
        Arrays.sort(arr);

        // 가장 작은 음수 2개, 가증 큰 양수 1개
        // 가장 큰 양수 3개
        int ppp = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
        int nnp = arr[arr.length - 1] * arr[0] * arr[1];
        return Math.max(ppp, nnp);
    }

}

