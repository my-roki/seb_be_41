package section1.java_basic.for_while;

/* 
sum
문제
수를 입력받아 0부터 해당 수까지의 합을 리턴해야 합니다.

입력
인자 1 : num
int 타입의 정수 (num >= 0)

출력
int 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.

입출력 예시
int output = sumTo(3);
System.out.println(output); // --> 6
 */

public class Q_01_sum {
    public static void main(String[] args) {
        Q_01_sum coplit = new Q_01_sum();
        System.out.println(coplit.sumTo(0));
        System.out.println(coplit.sumTo(4));
        System.out.println(coplit.sumTo(77));
    }

    public int sumTo(int num) {
        int result = 0;
        // TODO :
        for (int i = 0; i < num + 1; i++) {
            result += i;
        }
        return result;
    }
}