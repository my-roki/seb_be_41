package section1.java_basic.for_while;

/* 
makeMultiplesOfDigit

문제
수를 입력받아 1부터 해당 수까지의 수 중에서 3의 배수로만 구성된 문자열을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0) 이상의 정수)

출력
string 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
숫자(number string) 사이의 구분은 없습니다. ('3691215')
3의 배수가 없을 경우, 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = makeMultiplesOfDigit(7);
System.out.println(output); // --> "36"

output = makeMultiplesOfDigit(19);
System.out.println(output); // --> "369121518"

output = makeMultiplesOfDigit(2);
System.out.println(output); // --> ""
 */

public class Q_08_makeMultiplesOfDigit {
    public static void main(String[] args) {
        Q_08_makeMultiplesOfDigit coplit = new Q_08_makeMultiplesOfDigit();
        System.out.println(coplit.makeMultiplesOfDigit(1));
        System.out.println(coplit.makeMultiplesOfDigit(3));
        System.out.println(coplit.makeMultiplesOfDigit(9));
        System.out.println(coplit.makeMultiplesOfDigit(25));
        System.out.println(coplit.makeMultiplesOfDigit(55));
    }

    public String makeMultiplesOfDigit(int num) {
        // TODO:
        String result = "";
        for (int i = 3; i <= num; i += 3) {
            result += Integer.toString(i);
        }
        return result;
    }
}