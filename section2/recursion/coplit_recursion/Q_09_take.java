package section2.recursion.coplit_recursion;

/*
take
문제
수(num)와 배열을 입력받아 차례대로 num개의 요소만 포함된 새로운 배열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)
인자 2 : arr
int 타입의 요소를 갖는 배열

출력
순차적으로 num 개의 요소로 구성된 배열을 리턴해야 합니다.

주의 사항
함수 take는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).

입출력 예시
int[] output = take(2, new int[]{1, -2, 1, 3});
System.out.println(output); // --> [1, -2]

output = take(5, new int[]{1, -2, 1, 3});
System.out.println(output); // --> [1, -2, 1, 3]
 */


import java.util.Arrays;

public class Q_09_take {
    public static void main(String[] args) {
        // write test case here
        Q_09_take coplit = new Q_09_take();
        int[] output = coplit.take(2, new int[]{1, -2, 1, 3});
        System.out.println(Arrays.toString(output)); // --> [1, -2]

        output = coplit.take(5, new int[]{1, -2, 1, 3});
        System.out.println(Arrays.toString(output)); // --> [1, -2, 1, 3]

    }

    public int[] take(int num, int[] arr) {
        if (num >= arr.length) return arr;
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length - 1);
        return take(num, newArr);
    }
}
