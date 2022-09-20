package section2.recursion.coplit_recursion;

/*
drop
문제
수(num)와 배열을 입력받아 차례대로 num개의 요소가 제거된 새로운 배열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)
인자 2 : arr
int 타입의 요소를 갖는 배열

출력
순차적으로 num 개의 요소가 제거된 배열을 리턴해야 합니다.

주의 사항
함수 drop은 재귀함수의 형태로 작성합니다.
반복문(for, while) 사용은 금지됩니다.
입력받은 배열은 함수의 호출 뒤에도 처음 상태를 유지해야 합니다(immutability).
num과 arr.length 중 최소값만큼 제거합니다.

입출력 예시
int output = drop(2, new int[]{1, -2, 1, 3});
System.out.println(output); // --> [1, 3]

output = drop(5, new int[]{1, -2, 1, 3});
System.out.println(output); // --> [ ]
 */


import java.util.Arrays;

public class Q_08_drop {
    public static void main(String[] args) {
        // write test case here
        Q_08_drop coplit = new Q_08_drop();
        int[] output = coplit.drop(2, new int[]{1, -2, 1, 3});
        System.out.println(Arrays.toString(output)); // --> [1, 3]

        output = coplit.drop(5, new int[]{1, -2, 1, 3});
        System.out.println(Arrays.toString(output)); // --> [ ]

    }

    public int[] drop(int num, int[] arr) {
        if (num == 0 || arr.length == 0) return arr;
        int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        num -= 1;
        return drop(num, newArr);
    }

}
