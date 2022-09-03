package section1.java_basic.array;

/* 
getAllLetters

문제
문자열을 입력받아 문자열을 구성하는 각 문자를 요소로 갖는 배열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 공백이 없는 문자열

출력
char 타입의 요소를 가지는 배열을 리턴해야 합니다.

주의 사항
str.split 사용은 금지됩니다.
빈 문자열을 입력받은 경우, 빈 배열을 리턴해야 합니다.

입출력 예시
char[] output = getAllLetters("Radagast");
System.out.println(output); // --> ['R', 'a', 'd', 'a', 'g', 'a', 's', 't']
 */

public class Q_06_getAllLetters {
    public static void main(String[] args) {
        Q_06_getAllLetters coplit = new Q_06_getAllLetters();
        System.out.println(coplit.getAllLetters("Radagast"));
    }

    public char[] getAllLetters(String str) {
        // TODO:
        // 1. 문자열의 길이를 구한다.
        int len = str.length();

        // 2. 배열의 길이만큼 배열 생성.
        char[] result = new char[len];

        // 3. 문자열을 각 문자로 분리.
        for (int i = 0; i < len; i++) {
            char letter = str.charAt(i);

            // 4. 분리된 문자를 배열에 넣는다.
            result[i] = letter;
        }
        return result;
    }
}