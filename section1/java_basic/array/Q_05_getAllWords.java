package section1.java_basic.array;

/* 
getAllWords

문제
문자열을 입력받아 문자열을 구성하는 각 단어를 요소로 갖는 배열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 공백이 있는 문자열

출력
String 타입을 요소로 가지는 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
단어는 공백 한 칸으로 구분합니다.
연속된 공백은 없다고 가정합니다.

입출력 예시
String[] output = getAllWords("Radagast the Brown");
System.out.println(output); // --> ["Radagast", "the", "Brown"]

힌트
문자열은 str.split()를 사용하여 배열로 나누어 저장할 수 있습니다.
 */

public class Q_05_getAllWords {
    public static void main(String[] args) {
        Q_05_getAllWords coplit = new Q_05_getAllWords();
        System.out.println(coplit.getAllWords("Radagast the Brown"));
    }

    public String[] getAllWords(String str) {
        // TODO:
        if (str.length() == 0)
            return new String[0];
        return str.split(" ");
    }
}