package section1.java_basic.for_while;

/* 
makePermutations

문제
문자열을 입력받아 해당 문자열에 등장하는 각 문자(letter)를 가지고 만들 수 있는 길이 2의 문자열들을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열

출력
String 타입을 리턴해야 합니다.
입력받은 문자열의 각 문자를 0, 1, 2, ..., n이라고 할 경우, 00,01,02,...,nn 형식으로 리턴해야 합니다.

주의 사항
이중 반복문(double for loop)을 사용해야 합니다.
빈 문자열을 입력받은 경우에는 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = makePermutations("ab");
System.out.println(output); // --> "aa,ab,ba,bb"

output = makePermutations("123");
System.out.println(output); // --> "11,12,13,21,22,23,31,32,33"

output = makePermutations("");
System.out.println(output); // --> ""

힌트
문자열은 str.substring()을 활용해 잘라낼 수 있습니다.

String str = "codestates!";
System.out.println(str.substring(0, str.length() - 1));  // "codestates"
 */

public class Q_19_makePermutations {
    public static void main(String[] args) {
        Q_19_makePermutations coplit = new Q_19_makePermutations();
        System.out.println(coplit.makePermutations("ab"));
        System.out.println(coplit.makePermutations("123"));
        System.out.println(coplit.makePermutations(""));
    }

    public String makePermutations(String str) {
        // TODO:
        String result = "";

        if (str.isEmpty())
            return "";

        for (int left = 0; left < str.length(); left++) {
            for (int right = 0; right < str.length(); right++) {
                result = result + str.charAt(left) + str.charAt(right) + ",";
            }
        }

        return result.substring(0, result.length() - 1);
    }
}