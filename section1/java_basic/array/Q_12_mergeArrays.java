package section1.java_basic.array;

/* 
mergeArrays

문제
두 개의 배열을 입력받아 순서대로 합쳐진 배열을 리턴해야 합니다.

입력
인자 1 : arr1
int타입의 요소를 갖는 배열
인자 2 : arr2
int타입의 요소를 갖는 배열

출력
두 배열이 합쳐진 새로운 배열을 리턴해야 합니다.
[arr1[0], ..., arr1[n - 1], arr2[0], ..., arr2[m - 1]]
arr1.length는 n
arr2.length는 m

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
int[] output = mergeArrays(new int[]{1, 2}, new int[]{3, 4});
System.out.println(output); // --> [1, 2, 3, 4]
 */

public class Q_12_mergeArrays {
    public static void main(String[] args) {
        Q_12_mergeArrays coplit = new Q_12_mergeArrays();
        System.out.println(coplit.mergeArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        // TODO:
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        int[] output = new int[arr1Len + arr2Len];

        System.arraycopy(arr1, 0, output, 0, arr1Len);
        System.arraycopy(arr2, 0, output, arr1Len, arr2Len);

        return output;
    }
}