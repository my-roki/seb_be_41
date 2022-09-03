package section1.java_basic.array;

import java.util.Arrays;

/* 
createPhoneNumber

문제
0-9 사이의 정수를 요소로 갖는 배열을 입력받아 전화번호 형식의 문자열을 리턴해야 합니다.

입력
인자 1 : arr
int 타입을 요소로 갖는 배열
arr[i]는 0 이상 9 이하의 정수
배열의 길이는 8 또는 11

출력
String 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
배열의 길이가 8인 경우, 앞에 [0, 1, 0]이 있다고 가정합니다.

입출력 예시
String output = createPhoneNumber(new int[]{0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8});
System.out.println(output); // --> '(010)1234-5678'

output = createPhoneNumber(new int[]{8, 7, 6, 5, 4, 3, 2, 1});
System.out.println(output); // --> '(010)8765-4321'
 */

public class Q_18_createPhoneNumber {
    public static void main(String[] args) {
        Q_18_createPhoneNumber coplit = new Q_18_createPhoneNumber();
        System.out.println(coplit.createPhoneNumber(new int[] { 0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8 }));
        System.out.println(coplit.createPhoneNumber(new int[] { 8, 7, 6, 5, 4, 3, 2, 1 }));
    }

    public String createPhoneNumber(int[] arr) {
        // TODO:
        int arrLength = arr.length;

        // first number
        String firstNumber = "";
        if (arrLength == 11) {
            int[] first = Arrays.copyOfRange(arr, 0, 3);
            for (int i = 0; i < first.length; i++) {
                firstNumber += Integer.toString(first[i]);
            }
        } else {
            firstNumber = "010";
        }

        // middle number
        int[] middle = Arrays.copyOfRange(arr, arrLength - 8, arrLength - 4);
        String middleNumber = "";
        for (int i = 0; i < middle.length; i++) {
            middleNumber += Integer.toString(middle[i]);
        }

        // last number
        int[] last = Arrays.copyOfRange(arr, arrLength - 4, arrLength);
        String lastNumber = "";
        for (int i = 0; i < last.length; i++) {
            lastNumber += Integer.toString(last[i]);
        }

        return String.format("(%s)%s-%s", firstNumber, middleNumber, lastNumber);

    }
}
