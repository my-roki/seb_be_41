package section1.java_basic.for_while;

/* 
replaceAll

문제
문자열과 두 개의 문자(from, to)를 입력받아, 문자열에 등장하는 특정 문자(from)가 다른 문자(to)로 바뀐 문자열을 리턴해야 합니다.

입력
인자 1 : str
String 타입의 문자열
인자 2 : from
char 타입의 문자
인자 3 : to
char 타입의 문자

출력
String 타입을 리턴해야 합니다.
주의사항
반복문(for)문을 사용해야 합니다.

입출력 예시
String output = replaceAll("loop", 'o', 'e');
System.out.println(output); // --> "leep"
 */

public class Q_13_replaceAll {
    public static void main(String[] args) {
        Q_13_replaceAll coplit = new Q_13_replaceAll();
        System.out.println(coplit.replaceAll("loop", 'o', 'e'));
    }

    public String replaceAll(String str, char from, char to) {
        // TODO:
        String result = "";
        // str 에서 from 문자는 찾는다
        for (int i = 0; i < str.length(); i++) {
            // chatAt(n) => n번째 위치한 문자 1개를 가져오는 함수.
            // "Hello" => charAt(0) => H, charAt(1) => e
            char word = str.charAt(i);
            // H가 from이랑 같은지, 아닌지... e가 from이랑 같은지, 아닌지.
            if (word == from) { // 만약 from과 문자가 같으면?
                result += to;

            } else { // 만약 from과 문자가 다르면?
                result += word;
            }
        }

        return result;
    }
}