package section1.java_basic.array;

/* 
getLongestWord

문제
문자열을 입력받아 문자열에서 가장 긴 단어를 리턴해야 합니다.

입력
인자 1 : str
String 타입의 공백이 있는 알파벳 문자열

출력
String 타입을 리턴해야 합니다.

주의 사항
단어는 공백 한 칸으로 구분합니다.
가장 긴 단어가 2개 이상이면 첫번째로 등장하는 단어를 리턴해야 합니다.

입출력 예시
String output = getLongestWord("I love codestates");
System.out.println(output); // --> "codestates"

output = getLongestWord("Teamwork skills will take you anywhere");
System.out.println(output); // --> "Teamwork"
 */

public class Q_08_getLongestWord {
    public static void main(String[] args) {
        Q_08_getLongestWord coplit = new Q_08_getLongestWord();
        System.out.println(coplit.getLongestWord("I love codestates"));
        System.out.println(coplit.getLongestWord("Teamwork skills will take you anywhere"));
    }

    public String getLongestWord(String str) {
        // TODO:
        String[] arr = str.split(" ");

        String result = "";
        int resultLen = 0;
        for (int i = 0; i < arr.length; i++) {
            // 단어를 구한다.
            String letter = arr[i];

            // 단어의 길이를 구한다.
            int letterLen = letter.length();

            // 다음 단어와 비교해서 길이가 더 긴 것을 찾는다.
            // 만약 result가 letterLen 보다 크면? => result 유지.
            // 만약 result가 letterLen 보다 작으면? => result에 letterLen.
            // 만약 result가 letterLen 보다 같으면? => result 유지.
            // 찾았으면 변수에 저장
            if (resultLen < letterLen) {
                result = letter;
                resultLen = letterLen;
            }
        }
        // 그 변수를 리턴
        return result;

    }
}