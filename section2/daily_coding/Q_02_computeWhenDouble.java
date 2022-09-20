package section2.daily_coding;

/*
computeWhenDouble
문제
연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다.

입력
인자 1 : interestRate
double 타입의 연이율 (%)

출력
int 타입을 리턴해야 합니다.

입출력 예시
int output = computeWhenDouble(7);
System.out.println(output); // --> 11

output = computeWhenDouble(10);
System.out.println(output); // --> 8
 */


public class Q_02_computeWhenDouble {
    public static void main(String[] args) {
        // write test case here
        Q_02_computeWhenDouble coplit = new Q_02_computeWhenDouble();
        int output = coplit.computeWhenDouble(7);
        System.out.println(output); // --> 11

        output = coplit.computeWhenDouble(10);
        System.out.println(output); // --> 8

    }

    public int computeWhenDouble(double interestRate) {
        double principal = 1;  // 원금
        double interest = interestRate / 100;  // 이자율
        int output = 0;
        while (principal < 2) {
            // 1년 후 원금 = 원금 + 이자
            principal = principal + (principal * interest);
            output += 1;
        }
        return output;
    }
}