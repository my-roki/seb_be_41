package section1.java_effective.coplit_stream;

/*
findBiggestNumber

문제
int 타입을 요소로 가지는 배열을 입력받아 가장 큰 요소를 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 가지는 배열

출력
Integer 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우 null을 리턴해야 합니다.

입출력 예시
int[] arr = {1, 10, 5, 32, 5};
Integer output = findBiggestNumber(arr);
System.out.println(output); // 32

힌트
stream을 통해 배열의 요소를 순회할 수 있습니다.
stream의 다양한 연산으로 쉽게 원하는 값을 구할 수 있습니다.
 */

import java.util.Arrays;

public class Q_08_findBiggestNumber {
    public static void main(String[] args) {
        Q_08_findBiggestNumber coplit = new Q_08_findBiggestNumber();
        int[] arr = {1, 10, 5, 32, 5};
        Integer output = coplit.findBiggestNumber(arr);
        System.out.println(output); // 32
    }

    public Integer findBiggestNumber(int[] arr) {
        if (arr.length == 0) return null;
        int ouput = Arrays.stream(arr)
                .max()
                .getAsInt();
        return ouput;
    }
}