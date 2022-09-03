package section1.java_basic.for_while;

/* 
countCharacter

문제
문자열과 문자를 입력받아 문자열에서 문자(letter)가 등장하는 횟수를 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열
인자 2 : letter
char 타입의 문자

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
빈 문자열을 입력받은 경우, 0을 리턴해야 합니다.

입출력 예시
int output = countCharacter("I am a hacker", 'a');
System.out.println(output); // --> 3

힌트
문자열의 길이는 str.length()를 사용하여 구할 수 있습니다.

String str = "code"
int length = str.length();
System.out.println(length); // 4
 */

public class Q_11_countCharacter {
    public static void main(String[] args) {
        Q_11_countCharacter coplit = new Q_11_countCharacter();
        System.out.println(coplit.countCharacter("I am a hacker", 'a'));
    }

    public int countCharacter(String str, char letter) {
        // TODO:
        int counter = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == letter) {
                counter = counter + 1;
            }
        }

        return counter;
    }
}