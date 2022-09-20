package section2.daily_coding;

/*
firstReverse
문제
문자열을 입력받아 순서가 뒤집힌 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열

출력
String 타입을 리턴해야 합니다.

입출력 예시
String output = firstReverse("codestates");
System.out.println(output); // "setatsedoc"

output = firstReverse('I love codestates');
System.out.println(output); // "setatsedoc evol I"

힌트
문자열은 StringBuilder.reverse()를 통해 쉽게 뒤집을 수 있습니다.
 */


public class Q_05_firstReverse {
    public static void main(String[] args) {
        // write test case here
        Q_05_firstReverse coplit = new Q_05_firstReverse();
        String output = coplit.firstReverse("codestates");
        System.out.println(output); // "setatsedoc"

        output = coplit.firstReverse("I love codestates");
        System.out.println(output); // "setatsedoc evol I"

    }

    public String firstReverse(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}

