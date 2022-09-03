package section1.java_basic.array;

/* 
getElementsUpTo

문제
배열과 인덱스를 입력받아 주어진 인덱스 이전의 요소들을 갖는 새로운 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : n
int 타입의 인덱스 (0 이상의 정수)

출력
n번 인덱스 이전의 새로운 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
빈 배열을 입력받은 경우, 빈 배열을 리턴해야 합니다.
배열의 길이 이상의 인덱스를 입력받은 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
int[] output = getElementsUpTo(new int[]{1, 3, 5, 7, 9}, 2);
System.out.println(output); // --> [1, 3]
 */

public class Q_14_getElementsUpTo {
    public static void main(String[] args) {
        Q_14_getElementsUpTo coplit = new Q_14_getElementsUpTo();
        System.out.println(coplit.getElementsUpTo(new int[] { 1, 3, 5, 7, 9 }, 2));
    }

    public int[] getElementsUpTo(int[] arr, int n) {
        // TODO:
        if (arr.length < n)
            return new int[0];
        int[] output = new int[n];
        System.arraycopy(arr, 0, output, 0, n);
        return output;
    }
}