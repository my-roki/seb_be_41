package section2.daily_coding;

/*
readVertically
문제
문자열을 요소로 갖는 배열을 입력받아 문자열을 세로로 읽었을 때의 문자열을 리턴해야 합니다.

입력
인자 1 : arr
String 타입을 요소로 갖는 배열

출력
String 타입을 리턴해야 합니다.

주의 사항
각 문자열의 길이는 다양합니다.
각 문자의 위치를 행, 열로 나타낼 경우, 비어있는 (행, 열)은 무시합니다.

입출력 예시
String[] input = new String[]{
  "hello",
  "wolrd",
};
String output = readVertically(input);
System.out.println(output); // --> "hweolllrod"

input = new String[]{
  "hi",
  "wolrd",
};
output = readVertically(input);
System.out.println(output); // --> "hwiolrd"
 */

public class Q_13_readVertically {
    public static void main(String[] args) {
        // write test case here
        Q_13_readVertically coplit = new Q_13_readVertically();
        String[] input = new String[]{
                "hello",
                "wolrd",
        };
        String output = coplit.readVertically(input);
        System.out.println(output); // --> "hweolllrod"

        input = new String[]{
                "hi",
                "wolrd",
        };
        output = coplit.readVertically(input);
        System.out.println(output); // --> "hwiolrd"
    }

    public String readVertically(String[] arr) {
        String[][] newArr = new String[arr.length][];
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].split("");
            if (largest < arr[i].length()) largest = arr[i].length();
        }

        StringBuilder output = new StringBuilder();
        for (int j = 0; j < largest; j++) {
            for (String[] word : newArr) {
                try {
                    output.append(word[j]);
                } catch (Exception ignored){}
            }
        }
        return output.toString();
    }
}

