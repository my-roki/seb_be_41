package section1.java_basic.array;

/* 
getLastElement

문제
배열를 입력받아 배열의 마지막 요소를 리턴해야 합니다.

입력
인자 1 : arr
int타입의 요소를 갖는 배열

출력
배열의 요소를 리턴해야 합니다.

주의 사항
빈 배열을 입력받은 경우, -1를 리턴해야 합니다.

입출력 예시
int output = getLastElement(new int[]{1, 2, 3, 4});
System.out.println(output); // --> 4
 */

public class Q_02_getLastElement {
    public static void main(String[] args) {
        Q_02_getLastElement coplit = new Q_02_getLastElement();
        System.out.println(coplit.getLastElement(new int[] { 1, 2, 3, 4 }));
    }

    public int getLastElement(int[] arr) {
        // TODO:
        if (arr.length == 0)
            return -1;
        return arr[arr.length - 1];
    }
}