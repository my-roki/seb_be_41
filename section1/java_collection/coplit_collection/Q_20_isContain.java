package section1.java_collection.coplit_collection;

/* 
isContain

문제
<String, Integer> 타입을 요소로 가지는 HashMap과 문자열을 입력받아, HashMap에 문자열을 key로 한 Entry가 있는지의 여부를 리턴해야 합니다.

입력
인자 1 : hashMap
<String, Integer> 타입을 요소로 가지는 HashMap
인자 2 : key
임의의 문자열

출력
boolean 타입을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
HashMap<String, Integer> hashMap = new HashMap<String, Integer>(){{
	put("김코딩", 20);
	put("박해커", 25);
	put("최자바", 30);
}};
boolean output = isContain(hashMap, "김코딩");
System.out.println(output); // --> true
*/

import java.util.HashMap;

public class Q_20_isContain {
    public static void main(String[] args) {
        Q_20_isContain coplit = new Q_20_isContain();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("김코딩", 20);
            put("박해커", 25);
            put("최자바", 30);
        }};
        boolean output = coplit.isContain(hashMap, "김코딩");
        System.out.println(output); // --> true
    }

    public boolean isContain(HashMap<String, Integer> hashMap, String key) {
        return hashMap.containsKey(key);
    }
}