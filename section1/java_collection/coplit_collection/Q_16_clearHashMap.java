package section1.java_collection.coplit_collection;

/* 
clearHashMap

문제
<Integer, Boolean> 타입을 요소로 가지는 HashMap을 입력받아 모든 Entry를 제거합니다.

입력
인자 1 : hashMap
<Integer, Boolean> 타입을 요소로 가지는 HashMap

출력
별도의 리턴문(return statement)을 작성하지 않습니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>(){{
  put(1, true);
  put(3, false);
  put(5, true);
}};
clearHashMap(hashMap);
System.out.println(hashMap); // --> {}

힌트
메서드의 제목(clearHashMap)을 활용해 검색해 봅니다(java how to clear HashMap)
*/

import java.util.HashMap;

public class Q_16_clearHashMap {
    public static void main(String[] args) {
        Q_16_clearHashMap coplit = new Q_16_clearHashMap();

        HashMap<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>() {{
            put(1, true);
            put(3, false);
            put(5, true);
        }};
        coplit.clearHashMap(hashMap);
        System.out.println(hashMap); // --> {}
    }

    public void clearHashMap(HashMap<Integer, Boolean> hashMap) {
        hashMap.clear();
    }
}