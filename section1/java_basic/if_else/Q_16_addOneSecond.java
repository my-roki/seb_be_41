package section1.java_basic.if_else;

/*
addOneSecond

문제
시, 분, 초를 입력받아 1초를 더한 결과값을 특정 형태의 메시지로 리턴해야 합니다.

입력
인자 1 : hour
int 타입의 정수 (0 <= hour && hour < 24)
인자 2 : minute
int 타입의 정수 (0 <= minute && minute < 60)
인자 3 : second
int 타입의 정수 (0 <= second && second < 60)

출력
String 타입을 리턴해야 합니다.
1초 뒤에 {hour}시 {minute}분 {second}초 입니다 형식으로 리턴해야 합니다.

입출력 예시
String output = addOneSecond(14, 17, 59);
System.out.println(output); // --> "1초 뒤에 14시 18분 0초 입니다"

output = addOneSecond(1, 59, 59);
System.out.println(output); // --> "1초 뒤에 2시 0분 0초 입니다"

output = addOneSecond(3, 24, 29);
System.out.println(output); // --> "1초 뒤에 3시 24분 30초가 입니다"

output = addOneSecond(23, 59, 59);
System.out.println(output); // --> "1초 뒤에 0시 0분 0초 입니다"
*/

public class Q_16_addOneSecond {
    public static void main(String[] args) {
        Q_16_addOneSecond coplit = new Q_16_addOneSecond();
        System.out.println(coplit.addOneSecond(14, 17, 59));
        System.out.println(coplit.addOneSecond(1, 59, 59));
        System.out.println(coplit.addOneSecond(3, 24, 29));
        System.out.println(coplit.addOneSecond(23, 59, 59));

    }

    public String addOneSecond(int hour, int minute, int second) {
        // TODO:
        if (second == 59) {
            second = 0;
            minute += 1;
        } else {
            second += 1;
        }

        if (minute == 60) {
            minute = 0;
            hour += 1;
        }
        if (hour == 24) {
            hour = 0;
        }

        return String.format("1초 뒤에 %d시 %d분 %d초 입니다", hour, minute, second);

    }
}