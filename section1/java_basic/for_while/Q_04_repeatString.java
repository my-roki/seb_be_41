package section1.java_basic.for_while;

/* 
repeatString

문제
문자열과 수를 입력받아 반복된 문자열을 리턴해야 합니다.

입력
인자 1 : str
string 타입의 문자열
인자 2 : num
int 타입의 정수 (num >= 0)

출력
string 타입을 리턴해야 합니다.

주의 사항
반복문(for)문을 사용해야 합니다.
0을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = repeatString("code", 3);
System.out.println(output); // --> "codecodecode"

힌트
빈 문자열을 확인하는 방법은 str.isEmpty()를 사용하여 쉽게 확인이 가능합니다.
String str = "";
System.out.println(str.isEmpty()); // str이 빈 문자열일 경우 true를 반환합니다.
str = "code states";
System.out.println(str.isEmpty()); // str이  빈 문자열이 아닌 경우 false를 반환합니다.
 */

public class Q_04_repeatString {
    public static void main(String[] args) {
        Q_04_repeatString coplit = new Q_04_repeatString();
        System.out.println(coplit.repeatString("what", 3));
        System.out.println(coplit.repeatString("what", 0));
        System.out.println(coplit.repeatString("", 10000));

    }

    public String repeatString(String str, int num) {
        String result = "";
        // TODO:
        for (int i = 0; i < num; i++) {
            result += str;
        }
        return result;
    }
}