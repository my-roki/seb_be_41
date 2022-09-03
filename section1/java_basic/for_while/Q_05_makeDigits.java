package section1.java_basic.for_while;

/* 
makeDigits

문제
수(num)를 입력받아 1부터 num까지의 정수로 구성된 문자열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 1)

출력
string 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
숫자(number string) 사이의 구분은 없습니다. ('1234567')

입출력 예시
String output = makeDigits(5);
System.out.println(output); // --> "12345"

output = makeDigits(7);
System.out.println(output); // --> "1234567"
 */

public class Q_05_makeDigits {
    public static void main(String[] args) {
        Q_05_makeDigits coplit = new Q_05_makeDigits();
        System.out.println(coplit.makeDigits(1));
        System.out.println(coplit.makeDigits(5));
        System.out.println(coplit.makeDigits(13));
    }

    public String makeDigits(int num) {
        String result = "";

        for (int i = 1; i <= num; i++) {
            // String 타입의 값과 int타입의 값을 더해주는 경우, 자동으로 int타입의 값은 String으로 변환되어 저장됩니다.
            result = result + i;
        }

        return result;
    }
}