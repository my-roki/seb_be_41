package section1.java_basic.array;

/* 
getAllElementsButLast

문제
배열을 입력받아 마지막 요소를 제외한 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열

출력
마지막 요소를 제외한 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
int[] input = new int[]{1, 2, 3, 4};
int[] output = getAllElementsButLast(input);
System.out.println(output); // --> [1, 2, 3]
 */

public class Q_16_getAllElementsButLast {
    public static void main(String[] args) {
        Q_16_getAllElementsButLast coplit = new Q_16_getAllElementsButLast();
        int[] input = new int[] { 1, 2, 3, 4 };
        System.out.println(coplit.getAllElementsButLast(input));
    }

    public int[] getAllElementsButLast(int[] arr) {
        // TODO:
        if (arr.length == 0)
            return new int[0];
        int[] output = new int[arr.length - 1];
        System.arraycopy(arr, 0, output, 0, arr.length - 1);
        return output;
    }
}