package section2.daily_coding;

/*
letterCapitalize
문제
문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 공백이 있는 알파벳 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
단어는 공백으로 구분합니다.
연속된 공백이 존재할 수 있습니다.
빈 문자(공백)으로만 이루어진 문자열을 입력받은 경우, 빈 문자열을 리턴해야 합니다.

입출력 예시
String output1 = letterCapitalize('hello world');
System.out.println(output1); // "Hello World"
String output2 = letterCapitalize('java  is good ');
System.out.println(output2); // "Java  Is Good "
 */


public class Q_06_letterCapitalize {
    public static void main(String[] args) {
        // write test case here
        Q_06_letterCapitalize coplit = new Q_06_letterCapitalize();
        String output1 = coplit.letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
        String output2 = coplit.letterCapitalize("java  is good ");
        System.out.println(output2); // "Java  Is Good "
        String output3 = coplit.letterCapitalize("    ");
        System.out.println(output3); // ""
    }

    public String letterCapitalize(String str) {
        String[] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String word = strArr[i];
            String cap;
            if (word.equals("")) {
                cap = "";
            } else {
                cap = word.substring(0, 1).toUpperCase() + word.substring(1);
            }
            strArr[i] = cap;
        }
        return String.join(" ", strArr);
    }
}