package section1.java_basic.if_else;

/*
followingDay

문제
요일을 입력받아 해당 요일의 다음 요일을 리턴해야 합니다.

입력
인자 1 : day
String 문자열
가능한 요일: "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"

출력
String 타입을 리턴해야 합니다.
올바른 요일을 입력받은 경우, 다음 요일을 리턴해야 합니다.

주의 사항
올바른 요일이 아닌 경우에는 "올바른 요일이 아닙니다" 라는 문구를 리턴해야 합니다.

입출력 예시
String output = followingDay("월요일");
System.out.println(output); // --> "화요일"

output = followingDay("일요일");
System.out.println(output); // --> "월요일"

output = followingDay("월");
System.out.println(output); // --> "올바른 요일이 아닙니다"

output = followingDay("100");
System.out.println(output); // --> "올바른 요일이 아닙니다"

힌트
자바에서 문자열은 참조 자료형으로, ==연산자로 값을 비교할 수 없습니다.
str.equals()를 사용하여 두 변수의 값을 비교할 수 있습니다.

String str = "code";
str.equals("state"); // false;
str.equals("code"); // true
*/

public class Q_10_followingDay {
    public static void main(String[] args) {
        Q_10_followingDay coplit = new Q_10_followingDay();
        System.out.println(coplit.followingDay("월요일"));
        System.out.println(coplit.followingDay("일요일"));
        System.out.println(coplit.followingDay("월"));
        System.out.println(coplit.followingDay("100"));

    }

    public String followingDay(String day) {
        // TODO:
        if (day.equals("월요일")) {
            return "화요일";
        } else if (day.equals("화요일")) {
            return "수요일";
        } else if (day.equals("수요일")) {
            return "목요일";
        } else if (day.equals("목요일")) {
            return "금요일";
        } else if (day.equals("금요일")) {
            return "토요일";
        } else if (day.equals("토요일")) {
            return "일요일";
        } else if (day.equals("일요일")) {
            return "월요일";
        } else {
            return "올바른 요일이 아닙니다";
        }
    }
}