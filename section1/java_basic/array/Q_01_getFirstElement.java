package section1.java_basic.array;

/* 
getFirstElement

문제
배열을 입력받아 배열의 첫번째 요소를 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열

출력
배열의 요소를 리턴해야 합니다.

주의 사항
빈 배열을 입력받은 경우, -1를 리턴해야 합니다.

입출력 예시
int output = getFirstElement(new int[]{1, 2, 3, 4, 5});
System.out.println(output); // --> 1
 */

public class Q_01_getFirstElement {
    public static void main(String[] args) {
        Q_01_getFirstElement coplit = new Q_01_getFirstElement();
        System.out.println(coplit.getFirstElement(new int[] { 1, 2, 3, 4, 5 }));
    }

    public int getFirstElement(int[] arr) {
        // TODO:
        if (arr.length == 0)
            return -1;
        return arr[0];
    }
}