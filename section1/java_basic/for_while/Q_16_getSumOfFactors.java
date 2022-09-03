package section1.java_basic.for_while;

/* 
getSumOfFactors

문제
수를 입력받아 약수(factor)의 합을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 수

출력
int 타입을 리턴해야 합니다.
입출력 예시
int output = getSumOfFactors(8);
System.out.println(output); // --> 15 (1 + 2 + 4 + 8)

output = getSumOfFactors(12);
System.out.println(output); // --> 28 (1 + 2 + 3 + 4 + 6 + 12)
 */

public class Q_16_getSumOfFactors {
    public static void main(String[] args) {
        Q_16_getSumOfFactors coplit = new Q_16_getSumOfFactors();
        System.out.println(coplit.getSumOfFactors(8));
        System.out.println(coplit.getSumOfFactors(12));
    }

    public int getSumOfFactors(int num) {
        // TODO:
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                result += i;
            }
        }
        return result;
    }
}