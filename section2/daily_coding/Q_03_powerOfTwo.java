package section2.daily_coding;

/*
powerOfTwo
문제
수를 입력받아 2의 거듭제곱인지 여부를 리턴해야 합니다.

입력
인자 1 : num
long 타입의 정수 (num >= 1)

출력
boolean 타입을 리턴해야 합니다.

주의 사항
반복문(while)문을 사용해야 합니다.
2의 0승은 1입니다.
Math.log 사용은 금지됩니다.

입출력 예시
boolean output1 = powerOfTwo(16);
System.out.println(output1); // true
boolean output2 = powerOfTwo(22);
System.out.println(output2); // false
 */


public class Q_03_powerOfTwo {
    public static void main(String[] args) {
        // write test case here
        Q_03_powerOfTwo coplit = new Q_03_powerOfTwo();
        boolean output1 = coplit.powerOfTwo(16);
        System.out.println(output1); // true
        boolean output2 = coplit.powerOfTwo(22);
        System.out.println(output2); // false

    }

    public boolean powerOfTwo(long num) {
        while(num != 1) {
            if (num % 2 != 0) return false;
            num /= 2;
        }
        return true;
    }
}