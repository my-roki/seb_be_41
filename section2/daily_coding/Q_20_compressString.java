package section2.daily_coding;

/*
compressString
문제
문자열을 입력받아 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 알파벳 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.
3개 이상 연속되는 문자만 압축합니다.

입출력 예시
String output = compressString("abc");
System.out.println(output); // --> "abc"

output = compressString("wwwggoppopppp");
System.out.println(output); // --> "3wggoppo4p"
 */

import java.util.Arrays;

public class Q_20_compressString {
    public static void main(String[] args) {
        // write test case here
        Q_20_compressString coplit = new Q_20_compressString();

        String output = coplit.compressString("abc");
        System.out.println(output); // --> "abc"

        output = coplit.compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }

    public String compressString(String str) {
        // 빈 문자열일 경우 빈 문자열 반환
        if (str.length() == 0) return "";

        // 1. 순회할 문자 배열을 만든다.
        // 마지막 단어까지 비교하여 입력될 수 있도록 마지막에 더미 문자 1개 추가 합니다.
        // String[] letters = (str).split("");  // (x)
        String[] letters = (str + ' ').split("");  // (o)

        StringBuilder output = new StringBuilder();
        String compare = "";  // 비교할 문자
        int combo = 1;  // 연속된 문자 개수
        for (String target : letters) {
            // 2. 만약 비교하는 target 문자가 비교 대상 compare와 같으면 콤보를 잇기 위해 combo += 1, 다음 반복으로 넘어갑니다.
            if (compare.equals(target)) {
                combo += 1;
                continue;
            }

            // 3. 다르면 연속된 문자열이 끝난 것이므로 output에 문자를 입력한다.
            // 4. 단, combo가 3 이상이면 {combo}{문자}.
            if (combo >= 3) output.append(String.format("%d%s", combo, compare));
            // 5. combo가 2 이하이면 combo 만큼 문자반복.
            else output.append(compare.repeat(combo));

            // 다음 문자열의 콤보를 기록하기 위해 초기화.
            combo = 1;
            compare = target;
        }
        return output.toString();
    }
}


