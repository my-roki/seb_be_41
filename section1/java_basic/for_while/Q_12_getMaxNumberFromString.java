package section1.java_basic.for_while;

/* 
getMaxNumberFromString

문제
숫자 문자열을 입력받아 문자열을 구성하는 각 숫자 중 가장 큰 수를 나타내는 숫자를 리턴해야 합니다.

입력
인자 1 : str
String 타입의 숫자 문자열

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
str.split 사용은 금지됩니다.
빈 문자열을 입력받은 경우, 0을 리턴해야 합니다.

입출력 예시
int output = getMaxNumberFromString("53862");
System.out.println(output); // --> 8

output = getMaxNumberFromString("4321");
System.out.println(output); // --> 4
 */

public class Q_12_getMaxNumberFromString {
    public static void main(String[] args) {
        Q_12_getMaxNumberFromString coplit = new Q_12_getMaxNumberFromString();
        System.out.println(coplit.getMaxNumberFromString("53862"));
        System.out.println(coplit.getMaxNumberFromString("4321"));

    }

    public int getMaxNumberFromString(String str) {
        // TODO:
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char word = str.charAt(i);
            int target = Character.getNumericValue(word);
            if (target > result) {
                result = target;
            }
        }
        return result;
    }
}