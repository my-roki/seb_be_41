package section1.java_collection.coplit_collection;

/* 
getValue

문제
<String, Integer> 타입을 요소로 가지는 HashMap과 키를 입력받아, 키에 해당하는 값을 리턴해야 합니다.

입력
인자 1 : hashMap
<String, Integer> 타입을 요소로 가지는 HashMap
인자 2 : key
String 타입의 키

출력
Integer 타입의 값을 리턴해야 합니다.

입출력 예시
HashMap<String, Integer> hashMap; // {a=1, b=2, c=3}
Integer output = getValue(hashMap, "b");
System.out.println(output); // --> 2 
*/

import java.util.HashMap;

public class Q_13_getValue {
    public static void main(String[] args) {
        Q_13_getValue coplit = new Q_13_getValue();
        HashMap<String, Integer> hashMap = new HashMap<>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }}; // {a=1, b=2, c=3}
        Integer output = coplit.getValue(hashMap, "b");
        System.out.println(output); // --> 2

    }

    public Integer getValue(HashMap<String, Integer> hashMap, String key) {
        return hashMap.get(key);
    }
}