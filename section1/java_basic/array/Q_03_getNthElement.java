package section1.java_basic.array;

/* 
getNthElement

문제
배열과 수를 입력받아 수가 인덱스로 가리키는 배열의 요소를 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열
인자 2 : index
int 타입의 index (0 이상의 정수)

출력
배열의 요소를 리턴해야 합니다.

주의 사항
빈 배열을 입력받은 경우, -1를 리턴해야 합니다.
배열의 길이를 벗어나는 수를 입력받은 경우, '-2'를 리턴해야 합니다.

입출력 예시
int output = getNthElement(new int[]{1, 3, 5}, 1);
System.out.println(output); // --> 3

output = getNthElement(new int[]{1, 3, 5}, 3);
System.out.println(output); // --> '-2'
 */

public class Q_03_getNthElement {
    public static void main(String[] args) {
        Q_03_getNthElement coplit = new Q_03_getNthElement();
        System.out.println(coplit.getNthElement(new int[] { 1, 3, 5 }, 1));
        System.out.println(coplit.getNthElement(new int[] { 1, 3, 5 }, 3));
    }

    public int getNthElement(int[] arr, int index) {
        // TODO:
        int len = arr.length;
        if (len == 0)
            return -1;
        if (len <= index)
            return -2;
        return arr[index];
    }
}