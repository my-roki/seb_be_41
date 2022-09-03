package section1.java_basic.array;

/* 
addToBack

문제
배열과 요소를 입력받아 주어진 요소를 배열의 맨 뒤에 추가하고 해당 배열을 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : el
임의의 타입

출력
기존 배열에 주어진 요소가 추가된 형태의 배열을 리턴해야 합니다.
[arr[0], arr[1], ..., arr[n-1], el]
arr.length는 n

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
int[] output = addToBack([1, 2], 3);
System.out.println(output); // -> [1, 2, 3]
 */

public class Q_11_addToBack {
    public static void main(String[] args) {
        Q_11_addToBack coplit = new Q_11_addToBack();
        System.out.println(coplit.addToBack(new int[] { 1, 2 }, 3));
    }

    public int[] addToBack(int[] arr, int el) {
        // TODO:
        int[] output = new int[arr.length + 1];
        System.arraycopy(arr, 0, output, 0, arr.length);
        output[output.length - 1] = el;

        return output;
    }
}