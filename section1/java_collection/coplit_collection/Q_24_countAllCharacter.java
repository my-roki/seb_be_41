package section1.java_collection.coplit_collection;

/* 
countAllCharacters

문제
문자열을 입력받아 문자열을 구성하는 각 문자(letter)를 키로 갖는 HashMap을 리턴해야 합니다.
각 키의 값은 해당 문자가 문자열에서 등장하는 횟수를 의미하는 int 타입의 값이어야 합니다.

입력
인자 1 : str
String 타입의 공백이 없는 문자열

출력
<Character, Integer> 타입을 요소로 갖는 HashMap을 리턴해야 합니다.

주의 사항
빈 문자열을 입력받은 경우, null을 리턴해야 합니다.

입출력 예시
HashMap<Character, Integer> output = countAllCharacter("banana");
System.out.println(output); // --> {b=1, a=3, n=2}
*/

import java.util.HashMap;

public class Q_24_countAllCharacter {
    public static void main(String[] args) {
        Q_24_countAllCharacter coplit = new Q_24_countAllCharacter();
        HashMap<Character, Integer> output = coplit.countAllCharacter("banana");
        System.out.println(output); // --> {b=1, a=3, n=2}
    }

    public HashMap<Character, Integer> countAllCharacter(String str) {
        if (str.isEmpty()) return null;

        HashMap<Character, Integer> output = new HashMap<>();
        String[] arr = str.split("");
        for (String s : arr) {
            char key = s.charAt(0);
            if (output.containsKey(key)) output.put(key, output.get(key) + 1);
            else output.put(key, 1);
        }
        return output;
    }
}