
package section1.java_basic.string;

/* 
getLengthOfWord
문제
단어를 입력받아 단어의 길이를 리턴해야 합니다.

입력
인자 1 : word
String 타입의 문자열
word.length는 10 이하

출력
int 타입을 리턴해야 합니다.

입출력 예시
String output = getLengthOfWord("some");
System.out.println(output); // --> 4
 */

public class Q_14_getLengthOfWord {
    public static void main(String[] args) {
        Q_14_getLengthOfWord coplit = new Q_14_getLengthOfWord();
        System.out.println(coplit.getLengthOfWord(""));
        System.out.println(coplit.getLengthOfWord("codeStates"));
        System.out.println(coplit.getLengthOfWord("random"));
    }

    public int getLengthOfWord(String word) {
        // TODO:
        int len;
        len = word.length();
        return len;

    }
}