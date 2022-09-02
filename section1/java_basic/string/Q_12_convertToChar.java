
package section1.java_basic.string;

/* 
convertToChar

문제
숫자(int) 하나를 입력받아 알맞은 문자(char)를 리턴합니다.

입력
인자 1 : num
int 타입의 숫자

출력
char 타입을 리턴해야 합니다.

입출력 예시
int output = convertToChar(9);
system.out.println(output); // --> '9'
 */

public class Q_12_convertToChar {
    public static void main(String[] args) {
        Q_12_convertToChar coplit = new Q_12_convertToChar();
        System.out.println(coplit.convertToChar(9));
        System.out.println(coplit.convertToChar(4));
        System.out.println(coplit.convertToChar(1));
    }

    public char convertToChar(int num) {
        char result;
        // TODO: 여기에 코드를 작성합니다.
        // result = (char)(num+'0');
        result = Character.forDigit(num, 10);

        // 하단의 코드는 수정하지 말아야 합니다.
        return result;
    }
}