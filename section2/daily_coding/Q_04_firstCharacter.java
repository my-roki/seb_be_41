package section2.daily_coding;

/*
firstCharacter
문제
문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자로 이루어진 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 공백이 있는 알파벳 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
단어는 공백 한 칸으로 구분합니다.
연속된 공백은 없다고 가정합니다.
빈 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

입출력 예시
String output = firstCharacter("hello world");
System.out.println(output); // --> "hw"

output = firstCharacter("The community at Code States might be the biggest asset");
System.out.println(output); // --> "TcaCSmbtba"
 */


public class Q_04_firstCharacter {
    public static void main(String[] args) {
        // write test case here
        Q_04_firstCharacter coplit = new Q_04_firstCharacter();
        String output = coplit.firstCharacter("hello world");
        System.out.println(output); // --> "hw"

        output = coplit.firstCharacter("The community at Code States might be the biggest asset");
        System.out.println(output); // --> "TcaCSmbtba"
    }

    public String firstCharacter(String str) {
        if (str.length() == 0 ) return "";
        String[] strArr = str.split(" ");
        String output = "";
        for (String word : strArr) {
            output += word.charAt(0);
        }
        return output;
    }
}