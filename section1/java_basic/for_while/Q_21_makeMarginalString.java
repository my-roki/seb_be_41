
package section1.java_basic.for_while;

/* 
makeMarginalString

문제
문자열을 입력받아 해당 문자열을 처음부터 한 글자(letter)씩 다시 작성하려고 합니다. 
이 때, 한 글자를 추가할 때마다 부분적으로 완성된 문자열을 전부 이어붙인 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
이중 반복문(double for loop)을 사용해야 합니다.
str.split, str.substring 사용은 금지됩니다.
빈 문자열을 입력받은 경우에는 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = makeMarginalString("abc");
System.out.println(output); // --> "aababc"
// "a" + "ab" + "abc"

output = makeMarginalString("flower");
System.out.println(output); // --> "fflfloflowfloweflower"
// "f" + "fl" + "flo" + "flow" + "flowe" + "flower"

output = makeMarginalString("");
System.out.println(output); // --> ""
 */

public class Q_21_makeMarginalString {
    public static void main(String[] args) {
        Q_21_makeMarginalString coplit = new Q_21_makeMarginalString();
        System.out.println(coplit.makeMarginalString("abc"));
        System.out.println(coplit.makeMarginalString("flower"));
        System.out.println(coplit.makeMarginalString(""));

    }

    public String makeMarginalString(String str) {
        // TODO:
        String result = "";
        if (str == "")
            return result;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                result = result + str.charAt(j);
            }
        }
        return result;
    }
}