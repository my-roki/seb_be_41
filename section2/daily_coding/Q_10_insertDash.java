package section2.daily_coding;

/*
insertDash
문제
문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 숫자 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
0은 짝수로 간주합니다.

입출력 예시
String output = insertDash("454793");
System.out.println(output); // --> 4547-9-3
 */

public class Q_10_insertDash {
    public static void main(String[] args) {
        // write test case here
        Q_10_insertDash coplit = new Q_10_insertDash();
        String output = coplit.insertDash("454793");
        System.out.println(output); // --> 4547-9-3
    }

    public String insertDash(String str) {
        if (str.equals("")) return null;

        StringBuilder sb = new StringBuilder();
        String[] arr = str.split("");
        for (int i = 0; i < arr.length - 1; i++) {
            int leftNum = Integer.parseInt(arr[i]);
            int rightNum = Integer.parseInt((arr[i+1]));
            if (leftNum % 2 == 1 && rightNum % 2 ==1) {
                sb.append(leftNum).append("-");
            } else {
                sb.append(leftNum);
            }
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();
    }
}
