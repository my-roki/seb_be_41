package section1.java_basic.array;

/* 
computeSumOfAllElements

문제
배열을 입력받아 배열의 모든 요소의 합을 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열

출력
int 타입을 리턴해야 합니다.

주의 사항
입력받은 배열이 빈 배열인 경우, 0을 리턴해야 합니다.

int output = computeSumOfAllElements(new int[]{1, 2, 3});
System.out.println(output); // --> 6
 */

public class Q_04_computeSumOfAllElements {
    public static void main(String[] args) {
        Q_04_computeSumOfAllElements coplit = new Q_04_computeSumOfAllElements();
        System.out.println(coplit.computeSumOfAllElements(new int[] { 1, 2, 3 }));
    }

    public int computeSumOfAllElements(int[] arr) {
        // TODO:
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}