package section2.recursion.coplit_recursion;

/*
arrLength
문제
배열을 입력받아 그 길이를 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열

출력
int 타입을 리턴해야 합니다.
arr.length

주의 사항
함수 arrLength는 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).
빈 배열의 길이는 0입니다.

입출력 예시
int output = arrLength(new int[]{1, -2, 1, 3});
System.out.println(output); // --> 4
 */


import java.util.Arrays;

public class Q_07_arrLength {
    public static void main(String[] args) {
        // write test case here
        Q_07_arrLength coplit = new Q_07_arrLength();
        int output = coplit.arrLength(new int[]{1, -2, 1, 3});
        System.out.println(output); // --> 4

    }

    public int arrLength(int[] arr) {
        if (arr.length == 0) return 0;

        int output = 0;
        int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        output = 1 + arrLength(newArr);
        return output;
    }
}
