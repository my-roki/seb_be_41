package section1.java_basic.for_while;

/* 
findTheBug
문제
문자열을 입력받아 버그('#')의 인덱스를 리턴해야 합니다.

입력
인자 1 : word
String 타입의 단어

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
'#' 기호가 없는 경우 -1을 리턴해야 합니다.

입출력 예시
int output = findTheBug("wo#rd");
System.out.println(output); // --> 2

output = findTheBug("#hello");
System.out.println(output); // --> 0

output = findTheBug("bug");
System.out.println(output); // --> -1

힌트
모든 문자열의 인덱스는 0부터 시작합니다.
String타입의 문자열에서 한가지 문자(char)타입의 값을 사용하려면 word.charAt(문자열의 인덱스) 명령어를 사용해야 합니다.

String word = "abcdefg";
System.out.println(word.charAt(0)); // 'a'
System.out.println(word.charAt(2)); // 'c'
System.out.println(word.charAt(5)); // 'f'
 */

public class Q_10_findTheBug {
    public static void main(String[] args) {
        Q_10_findTheBug coplit = new Q_10_findTheBug();
        System.out.println(coplit.findTheBug("cup#"));
        System.out.println(coplit.findTheBug("#lizard"));
        System.out.println(coplit.findTheBug("spider"));
        System.out.println(coplit.findTheBug(""));
    }

    public int findTheBug(String word) {
        // TODO:
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '#') {
                return i;
            }
        }
        return -1;
    }
}