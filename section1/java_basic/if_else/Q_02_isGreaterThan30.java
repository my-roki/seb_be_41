package section1.java_basic.if_else;

/*
isGreaterThan30

문제
온도를 입력받아 해당 온도가 30이 넘는지 확인 후 알맞은 값을 리턴해야 합니다.

입력
인자 1 : temp
int 타입의 온도

출력
String 타입을 리턴해야 합니다.
온도가 30 미만일 때 : "여름이 매우 덥네요"
온도가 30 이상일 때 : "에어컨을 켜야겠다!"

입출력 예시
String output = isGreaterThan30(29);
System.out.println(output); // --> "여름이 매우 덥네요"

output = isGreaterThan30(30);
System.out.println(output); // --> "에어컨을 켜야겠다!"
*/

public class Q_02_isGreaterThan30 {
    public static void main(String[] args) {
        Q_02_isGreaterThan30 coplit = new Q_02_isGreaterThan30();
        System.out.println(coplit.isGreaterThan30(29));
        System.out.println(coplit.isGreaterThan30(30));

    }

    public String isGreaterThan30(int temp) {
        // TODO:
        if (temp < 30) {
            return "여름이 매우 덥네요";
        }
        return "에어컨을 켜야겠다!";
    }
}