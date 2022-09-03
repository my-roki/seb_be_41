package section1.java_basic.array;

/* 
getElementsAfter

문제
배열과 인덱스를 입력받아 주어진 인덱스 이후의 요소들을 갖는 새로운 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : n
int 타입의 인덱스 (0 이상의 정수)

출력
n번 인덱스부터 새로운 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우, 빈 배열을 리턴해야 합니다.
배열의 길이 이상의 인덱스를 입력받은 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
int[] output = getElementsAfter(new int[]{1, 3, 5, 7, 9}, 2);
System.out.println(output); // --> [5, 7, 9]
 */

public class Q_13_getElementsAfter {
    public static void main(String[] args) {
        Q_13_getElementsAfter coplit = new Q_13_getElementsAfter();
        System.out.println(coplit.getElementsAfter(new int[] { 1, 3, 5, 7, 9 }, 2));
    }

    public int[] getElementsAfter(int[] arr, int n) {
        // TODO:
        if (arr.length < n)
            return new int[0];

        int[] output = new int[arr.length - n];
        System.arraycopy(arr, n, output, 0, arr.length - n);
        return output;
    }
}