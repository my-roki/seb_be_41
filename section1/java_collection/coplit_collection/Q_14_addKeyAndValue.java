package section1.java_collection.coplit_collection;

/* 
addKeyAndValue

문제
<String, Integer> 타입을 요소로 가지는 HashMap과 Key, Value를 입력받아 HashMap에 Key-Value 쌍을 추가한 후 새롭게 추가된 요소를 포함한 HashMap을 리턴해야 합니다.

입력
인자 1 : hashMap
<String, Integer> 타입을 요소로 가지는 HashMap
인자 2 : key
String 타입의 키
인자 3 : value
int 타입의 값

출력
<String, Integer> 타입을 요소로 가지는 HashMap

주의 사항
반복문(for, while) 사용은 금지됩니다.
HashMap에 key - Value 쌍을 저장해야합니다.

입출력 예시
HashMap<String, Integer> hashMap = new HashMap<>(){{
      put("a", 1);
      put("b", 2);
      put("c", 3);
    }};
HashMap<String, Integer> output = addKeyAndValue(hashMap, "d", 4);
System.out.println(output); // {a=1, b=2, c=3, d=4}
*/

import java.util.HashMap;

public class Q_14_addKeyAndValue {
    public static void main(String[] args) {
        Q_14_addKeyAndValue coplit = new Q_14_addKeyAndValue();
        HashMap<String, Integer> hashMap = new HashMap<>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }};
        HashMap<String, Integer> output = coplit.addKeyAndValue(hashMap, "d", 4);
        System.out.println(output); // {a=1, b=2, c=3, d=4}
    }

    public HashMap<String, Integer> addKeyAndValue(HashMap<String, Integer> hashMap, String key, int value) {
        hashMap.put(key, value);
        return  hashMap;
    }
}