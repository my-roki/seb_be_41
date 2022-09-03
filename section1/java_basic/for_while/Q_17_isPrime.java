package section1.java_basic.for_while;

/* 
isPrime
문제
1 이상의 자연수를 입력받아 소수(prime number)인지 여부를 리턴해야 합니다.

입력
인자 1 : num
int 타입의 수

출력
boolean 타입을 리턴해야 합니다.

입출력 예시
boolean output = isPrime(2);
System.out.println(output); // --> true

output = isPrime(6);
System.out.println(output); // --> false

output = isPrime(17);
System.out.println(output); // --> true

힌트
Math를 활용해 불필요한 연산을 줄일 수 있습니다. (how to find java square root 또는 자바 제곱근)
 */

public class Q_17_isPrime {
    public static void main(String[] args) {
        Q_17_isPrime coplit = new Q_17_isPrime();
        System.out.println(coplit.isPrime(2));
        System.out.println(coplit.isPrime(6));
        System.out.println(coplit.isPrime(17));
    }

    public boolean isPrime(int num) {
        // TODO:
        if (num == 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}