
package section1.java_basic.string;

/* 
compareOnlyAlphabet

문제
두 개의 문자열을 입력받아 대소문자를 구분하지 않고(case insensitive) 서로 같은지 여부를 리턴해야 합니다.

입력
인자 1 : str1
String 타입의 문자열

인자 2 : str2
String 타입의 문자열

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean output = compareOnlyAlphabet("hello", "HELLO");
System.out.println(output); // --> true

output = compareOnlyAlphabet("world", "WORD");
System.out.println(output); // --> false

힌트
두 문자열을 모두 대문자(upperCase) 또는 소문자(lowerCase)로 바꾸면, 두 문자열을 오직 알파벳 기준(대소문자 구분 X)으로만 비교할 수 있습니다.
 */

public class Q_17_compareOnlyAlphabet {
    public static void main(String[] args) {
        Q_17_compareOnlyAlphabet coplit = new Q_17_compareOnlyAlphabet();
        System.out.println(coplit.compareOnlyAlphabet("SeCrEt", "sEcReT"));
        System.out.println(coplit.compareOnlyAlphabet("SeCrEt", "sEKReT"));
        System.out.println(coplit.compareOnlyAlphabet("codestates", "codeSTATES"));
        System.out.println(coplit.compareOnlyAlphabet("SeCrEt", "sEcReTs"));
        System.out.println(coplit.compareOnlyAlphabet("hello", "world"));
    }

    public boolean compareOnlyAlphabet(String str1, String str2) {
        // TODO:
        // str을 소문자로 바꾼다.
        String newStr1 = str1.toLowerCase();
        String newStr2 = str2.toLowerCase();

        // 비교 결과를 담을 논리 타입 변수를 선언한다.
        boolean result;

        // 바꾼 두 문자를 비교한다. 비교 결과를 변수에 담는다.
        // result = newStr1 == newStr2;
        result = newStr1.equals(newStr2);

        // 변수를 return 한다.
        return result;

    }

}