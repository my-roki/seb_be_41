package section1.java_collection.coplit_collection;

/* 
select
문제
String 타입을 요소로 가지는 배열과 <String, Integer> 타입을 요소로 가지는 HashMap을 입력받아,
배열의 각 요소들을 HashMap의 키로 했을 때 그 값을 추출하여 만든 새로운 HashMap을 리턴해야 합니다.

입력
인자 1 : arr
String 타입을 요소로 가지는 배열
인자 2 : hashMap
<String, Integer> 타입을 요소로 가지는 HashMap

출력
새로운 HashMap을 리턴해야 합니다.

주의 사항
입력받은 HashMap에 존재하지 않는 키는 무시합니다.
입력받은 HashMap을 수정하지 않아야 합니다.

입출력 예시
String[] arr = {"a", "c", "e"};
HashMap<String, Integer> hashMap = new HashMap<String, Integer>(){{
	put("a", 1);
	put("b", 2);
	put("c", 3);
}};
HashMap<String, Integer> output = select(arr, hashMap);
System.out.println(output); // --> { "a"=1, "c"=3 }
*/

import java.util.HashMap;

public class Q_23_select {
    public static void main(String[] args) {
        Q_23_select coplit = new Q_23_select();
        String[] arr = {"a", "c", "e"};
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }};
        HashMap<String, Integer> output = coplit.select(arr, hashMap);
        System.out.println(output); // --> { "a"=1, "c"=3 }

    }

    public HashMap<String, Integer> select(String[] arr, HashMap<String, Integer> hashMap) {
        HashMap<String, Integer> output = new HashMap<>();
        for (String candidate: arr) {
            if (hashMap.containsKey(candidate)){
                output.put(candidate, hashMap.get(candidate));
            }
        }
        return output;
    }
}