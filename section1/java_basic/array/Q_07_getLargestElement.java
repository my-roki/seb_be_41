package section1.java_basic.array;

import java.util.Arrays;

/* 
getLargestElement

문제
배열을 입력받아 가장 큰 요소를 리턴해야 합니다.

입력
인자 1 : arr
int 타입의 정수로 구성된 배열

출력
int 타입을 리턴해야 합니다.

입출력 예시
int output = getLargestElement(new int[]{1, 4, 3});
System.out.println(output); // --> 4

output = getLargestElement(new int[]{-4, -2, -9});
System.out.println(output); // --> -2
 */

public class Q_07_getLargestElement {
    public static void main(String[] args) {
        Q_07_getLargestElement coplit = new Q_07_getLargestElement();
        System.out.println(coplit.getLargestElement(new int[] { 1, 4, 3 }));
        System.out.println(coplit.getLargestElement(new int[] { -4, -2, -9 }));
    }

    public int getLargestElement(int[] arr) {
        // TODO:
        return Arrays.stream(arr).max().getAsInt();

    }
}