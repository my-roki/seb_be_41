package section1.java_basic.for_while;

/* 
listPrimes

문제
2 이상의 자연수를 입력받아 2부터 해당 수까지의 소수(prime number)들을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 2)

출력
String 타입을 리턴해야 합니다.
2-3-5-7의 형식으로 리턴해야 합니다.

주의 사항
이중 반복문(double for loop)을 사용해야 합니다.

입출력 예시
String output = listPrimes(2);
System.out.println(output); // --> '2'

output = listPrimes(6);
System.out.println(output); // --> '2-3-5'

output = listPrimes(18);
System.out.println(output); // --> '2-3-5-7-11-13-17'
 */

public class Q_18_listPrimes {
    public static void main(String[] args) {
        Q_18_listPrimes coplit = new Q_18_listPrimes();
        System.out.println(coplit.listPrimes(2));
        System.out.println(coplit.listPrimes(6));
        System.out.println(coplit.listPrimes(18));
    }

    public String listPrimes(int num) {
        // TODO:
        String result = "2";
        for (int i = 3; i <= num; i += 2) {
            boolean isPrime = true;
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                result += "-" + i;
            }
        }

        return result;
    }
}