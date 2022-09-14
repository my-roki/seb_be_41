package section1.java_collection.coplit_collection;

/* 
removeEntry

문제
<String, String> 타입을 요소로 가지는 HashMap과 문자열을 입력받아, String 타입을 key로 갖고있는 Entry를 제거합니다.

입력
인자 1 : hashMap
<String, String> 타입을 요소로 가지는 HashMap
인자 2 : key
임의의 문자열

출력
별도의 리턴문(return statement)을 작성하지 않습니다.

주의 사항
인자로 전달받은 문자열은 key로서 항상 존재합니다.
반복문(for, while) 사용은 금지됩니다.

입출력 예시
HashMap<String, Integer> hashMap; // {a=1, b=2, c=3}
removeEntry(hashMap, "b");
System.out.println(hashMap); // --> {a=1, c=3}
*/

import java.util.HashMap;

public class Q_15_removeEntry {
    public static void main(String[] args) {
        Q_15_removeEntry coplit = new Q_15_removeEntry();
        HashMap<String, Integer> hashMap = new HashMap<>(){{
            put("a",1);
            put("b",2);
            put("c",3);
        }}; // {a=1, b=2, c=3}
        coplit.removeEntry(hashMap, "b");
        System.out.println(hashMap); // --> {a=1, c=3}
    }

    public void removeEntry(HashMap<String, Integer> hashMap, String key) {
        hashMap.remove(key);
    }
}