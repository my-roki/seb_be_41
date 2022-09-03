package section1.java_basic.array;

/* 
getAllElementsButFirst

문제
배열을 입력받아 배열의 첫번째 요소를 제외한 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열

출력
배열의 첫번째 요소를 제외한 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
int[] input = new int[]{1, 2, 3, 4};
int[] output = getAllElementsButFirst(input);
System.out.println(output); // --> [2, 3, 4]
 */

public class Q_15_getAllElementsButFirst {
    public static void main(String[] args) {
        Q_15_getAllElementsButFirst coplit = new Q_15_getAllElementsButFirst();
        int[] input = new int[] { 1, 2, 3, 4 };
        System.out.println(coplit.getAllElementsButFirst(input));
    }

    public int[] getAllElementsButFirst(int[] arr) {
        // TODO:
        if (arr.length == 0)
            return new int[0];
        int[] output = new int[arr.length - 1];
        System.arraycopy(arr, 1, output, 0, arr.length - 1);
        return output;
    }
}