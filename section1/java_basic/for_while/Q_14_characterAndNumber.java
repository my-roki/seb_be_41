package section1.java_basic.for_while;

/* 
characterAndNumber

문제
문자열을 입력받아 각 문자(letter) 뒤에 해당 문자의 인덱스가 추가된 문자열을 리턴해야 합니다.

입력
인자 1 : word
String 타입의 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = characterAndNumber('hello');
System.out.println(output); // --> 'h0e1l2l3o4'

output = characterAndNumber('cup');
System.out.println(output); // --> 'c0u1p2'
 */

public class Q_14_characterAndNumber {
    public static void main(String[] args) {
        Q_14_characterAndNumber coplit = new Q_14_characterAndNumber();
        System.out.println(coplit.characterAndNumber("word"));
        System.out.println(coplit.characterAndNumber("hello"));
        System.out.println(coplit.characterAndNumber("cup"));
    }

    public String characterAndNumber(String word) {
        // TODO:
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            result += letter + Integer.toString(i);
        }
        return result;
    }
}