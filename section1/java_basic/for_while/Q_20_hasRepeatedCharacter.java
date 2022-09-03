package section1.java_basic.for_while;

/* 
hasRepeatedCharacter
문제
문자열을 입력받아 해당 문자열에 중복된 문자(letter)가 존재하는지 여부를 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열

출력
boolean 타입을 리턴해야 합니다.

주의 사항
이중 반복문(double for loop)을 사용해야 합니다.
빈 문자열을 입력받은 경우에는 false을 리턴해야 합니다.

입출력 예시
let output = hasRepeatedCharacter("abcdefg");
System.out.println(output); // --> false

output = hasRepeatedCharacter("codestates");
System.out.println(output); // --> true

output = hasRepeatedCharacter("");
System.out.println(output); // --> false
 */

public class Q_20_hasRepeatedCharacter {
    public static void main(String[] args) {
        Q_20_hasRepeatedCharacter coplit = new Q_20_hasRepeatedCharacter();
        System.out.println(coplit.hasRepeatedCharacter("abcdefg"));
        System.out.println(coplit.hasRepeatedCharacter("codestates"));
        System.out.println(coplit.hasRepeatedCharacter(""));

    }

    public boolean hasRepeatedCharacter(String str) {
        // TODO:
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return true;
            }
        }
        return false;
    }
}