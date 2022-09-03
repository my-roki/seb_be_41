package section1.java_basic.for_while;

/* 
makeOddDigits

문제
수(num)를 입력받아 1을 포함하여 num개의 홀수로 구성된 문자열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 1)

출력
string 타입을 리턴해야 합니다.

주의 사항
반복문(while)문을 사용해야 합니다.
숫자(number string) 사이의 구분은 없습니다. ('13579')

입출력 예시
1String output = makeOddDigits(3);
System.out.println(output); // --> "135"

output = makeOddDigits(5);
System.out.println(output); // --> "13579"
 */

public class Q_07_makeOddDigits {
    public static void main(String[] args) {
        Q_07_makeOddDigits coplit = new Q_07_makeOddDigits();
        System.out.println(coplit.makeOddDigits(1));
        System.out.println(coplit.makeOddDigits(5));
        System.out.println(coplit.makeOddDigits(7));
        System.out.println(coplit.makeOddDigits(25));
    }

    public String makeOddDigits(int num) {
        // TODO:
        String result = "";
        int i = 1;
        // n 개수만큼의 홀수.
        while (i < num * 2) {
            // 숫자들을 문자열로 변환후 누적.
            result += Integer.toString(i);
            i += 2;
        }
        return result;
    }
}