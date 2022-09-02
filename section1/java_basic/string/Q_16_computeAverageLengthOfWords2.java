
package section1.java_basic.string;

/* 
computeAverageLengthOfWords2

문제
두 단어를 입력받아 두 단어의 평균 길이를 내림하여 리턴해야 합니다.

입력
인자 1 : word1
String 타입의 알파벳 문자열
word1.length()는 10 이하

인자 2 : word2
String 타입의 알파벳 문자열
word2.length()는 10 이하

출력
int 타입을 리턴해야 합니다.

주의 사항
평균 길이를 내림하여 리턴해야 합니다.

입출력 예시
int output = computeAverageLengthOfWords2("code", "programs");
System.out.println(output); // --> 6

output = computeAverageLengthOfWords2("code", "codes");
System.out.println(output); // --> 4

힌트
Math 를 검색해 봅니다. (java math object 또는 자바 math)
자바에서의 내림 연산을 직접 검색해 봅니다. (자바 내림)
 */

public class Q_16_computeAverageLengthOfWords2 {
    public static void main(String[] args) {
        Q_16_computeAverageLengthOfWords2 coplit = new Q_16_computeAverageLengthOfWords2();
        System.out.println(coplit.computeAverageLengthOfWords2("was", "this"));
        System.out.println(coplit.computeAverageLengthOfWords2("chicken", "beer"));
        System.out.println(coplit.computeAverageLengthOfWords2("is", "this"));
        System.out.println(coplit.computeAverageLengthOfWords2("code", "states"));
    }

    public int computeAverageLengthOfWords2(String word1, String word2) {
        // TODO;
        int word1Len = word1.length();
        int word2Len = word2.length();

        double averageLength = (word1Len + word2Len) / 2;
        return (int) Math.floor(averageLength);
    }
}