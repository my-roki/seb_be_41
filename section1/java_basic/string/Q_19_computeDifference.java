
package section1.java_basic.string;

/* 
showTime

문제
시간, 분, 초를 입력받아 현재 시각을 나타내는 메세지를 리턴해야 합니다.

입력
인자 1 : hour
int 타입의 시간 (1 이상 12 이하의 정수)

인자 2 : min
int 타입의 분 (0 이상 59 이하의 정수)

인자 3 : sec
int 타입의 초 (0 이상 59 이하의 정수)

출력
String 타입을 리턴해야 합니다.

주의 사항
플러스 연산자(+) 사용은 금지됩니다. ('현재 시각은 ' + hour + '시 ' + min + '분 ' + sec + '초 입니다.')

입출력 예시
String output = showTime(1, 30, 25);
System.out.println(output); // --> '현재 시각은 1시 30분 25초 입니다.'

힌트
String.format을 찾아봅시다.
 */

public class Q_19_computeDifference {
    public static void main(String[] args) {
        Q_19_computeDifference coplit = new Q_19_computeDifference();
        System.out.println(coplit.computeDifference(2, 10));
        System.out.println(coplit.computeDifference(10, 2));
    }

    public String computeDifference(int num1, int num2) {
        int sub = Math.abs(num1 - num2);
        return String.format("%d, %d의 차이는 %d입니다.", num1, num2, sub);
    }
}