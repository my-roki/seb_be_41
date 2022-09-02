
package section1.java_basic.string;

/* 
computeAverageLengthOfWords

문제
두 단어를 입력받아 두 단어의 평균 길이를 리턴해야 합니다.

입력
인자 1 : word1
String 타입의 알파벳 문자열
word1.length()는 10 이하

인자 2 : word2
String 타입의 알파벳 문자열
word2.length()는 10 이하

출력
int 타입을 리턴해야 합니다.

입출력 예시
int output = computeAverageLengthOfWords('code', 'programs');
System.out.println(output); // --> 6
 */

public class Q_15_computeAverageLengthOfWords {
    public static void main(String[] args) {
        Q_15_computeAverageLengthOfWords coplit = new Q_15_computeAverageLengthOfWords();
        System.out.println(coplit.computeAverageLengthOfWords("chicken", "beers"));
        System.out.println(coplit.computeAverageLengthOfWords("code", "states"));
        System.out.println(coplit.computeAverageLengthOfWords("is", "this"));
    }

    public int computeAverageLengthOfWords(String word1, String word2) {
        // TODO:
        int word1Length = word1.length();
        int word2Length = word2.length();
        int avg = (word1Length + word2Length) / 2;
        return avg;
    }
}