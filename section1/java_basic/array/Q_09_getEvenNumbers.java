package section1.java_basic.array;

/* 
getEvenNumbers

문제
int 타입를 요소로 갖는 배열을 입력받아 짝수만을 요소로 갖는 배열을 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 양의 정수

출력
int 타입을 요소로 가지는 배열을 리턴해야 합니다.

주의 사항
짝수가 없는 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
int[] output = getEvenNumbers(new int[]{1, 2, 3, 4});
System.out.println(output); // --> [2, 4]
 */

public class Q_09_getEvenNumbers {
    public static void main(String[] args) {
        Q_09_getEvenNumbers coplit = new Q_09_getEvenNumbers();
        System.out.println(coplit.getEvenNumbers(new int[] { 1, 2, 3, 4 }));
    }

    public int[] getEvenNumbers(int[] arr) {
        // TODO:
        // 새로 만들어야 하는 배열의 길이 (짝수의 개수만큼 길이 설정)
        // 전체 배열에서 반복문을 돌려 짝수가 있으면 +=1
        int newArrLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                newArrLen += 1;
            }
        }

        // 새로운 배열을 만든다 => int[] arr = new int[length]
        int[] newArr = new int[newArrLen];
        int num = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                newArr[num] = arr[j];
                num++;
            }
        }
        return newArr;
    }
}