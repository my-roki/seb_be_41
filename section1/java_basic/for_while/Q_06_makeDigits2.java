package section1.java_basic.for_while;

/* 
makeDigits2

문제
수(num)를 입력받아 1부터 num까지의 정수로 구성된 문자열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 1)

출력
string 타입을 리턴해야 합니다.

주의 사항
반복문(while)문을 사용해야 합니다.
for문 사용은 금지됩니다.
숫자(number string) 사이를 '-'로 구분합니다. ('1-2-3-4-5')

입출력 예시
String output = makeDigits2(5);
System.out.println(output); // --> "1-2-3-4-5"

output = makeDigits2(7);
System.out.println(output); // --> "1-2-3-4-5-6-7"
 */

public class Q_06_makeDigits2 {
    public static void main(String[] args) {
        Q_06_makeDigits2 coplit = new Q_06_makeDigits2();
        System.out.println(coplit.makeDigits2(1));
        System.out.println(coplit.makeDigits2(5));
        System.out.println(coplit.makeDigits2(13));
    }

    public String makeDigits2(int num) {
        // TODO:
        String result = "1";
        int i = 2;
        while (i <= num) {
            result += "-" + Integer.toString(i);
            i++;
        }
        return result;
    }
}