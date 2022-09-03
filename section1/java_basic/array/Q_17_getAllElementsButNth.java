package section1.java_basic.array;

/* 
getAllElementsButNth

문제
배열과 인덱스를 입력받아 해당 인덱스의 요소를 제외한 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : n
int 타입의 인덱스

출력
인덱스에 해당하는 요소를 제외한 배열을 리턴해야 합니다.

주의 사항
배열의 길이보다 큰 인덱스를 입력받은 경우, 배열 그대로를 리턴해야 합니다.

입출력 예시
int[] output = getAllElementsButNth([1, 2, 3], 1);
System.out.println(output); // --> [1, 3]
 */

public class Q_17_getAllElementsButNth {
    public static void main(String[] args) {
        Q_17_getAllElementsButNth coplit = new Q_17_getAllElementsButNth();
        System.out.println(coplit.getAllElementsButNth(new int[] { 1, 2, 3 }, 1));
    }

    public int[] getAllElementsButNth(int[] arr, int n) {
        // TODO:
        if (arr.length < n)
            return arr;
        if (arr.length == 0)
            return new int[0];
        int[] output = new int[arr.length - 1];
        System.arraycopy(arr, 0, output, 0, n);
        System.arraycopy(arr, n + 1, output, n, arr.length - (n + 1));
        return output;
    }
}
