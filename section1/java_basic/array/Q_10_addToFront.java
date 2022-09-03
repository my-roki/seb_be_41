package section1.java_basic.array;

/* 
addToFront

문제
배열과 요소를 입력받아 주어진 요소를 배열의 맨 앞에 추가하고 해당 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : el
int타입의 정수

출력
주어진 요소가 추가된 형태의 배열을 리턴해야 합니다.
[arr[0], arr[1], ..., arr[n-1], el]
arr.length는 n

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
int[] output = addToFront(new int[]{1, 2}, 3);
System.out.println(output); // -> [3, 1, 2]
 */

public class Q_10_addToFront {
    public static void main(String[] args) {
        Q_10_addToFront coplit = new Q_10_addToFront();
        System.out.println(coplit.addToFront(new int[] { 1, 2 }, 3));
    }

    public int[] addToFront(int[] arr, int el) {
        // TODO:
        int[] output = new int[arr.length + 1];
        output[0] = el;
        System.arraycopy(arr, 0, output, 1, arr.length);

        return output;
    }
}