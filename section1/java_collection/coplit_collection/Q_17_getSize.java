package section1.java_collection.coplit_collection;

/* 
getSize

문제
<Integer, Integer> 타입을 요소로 가지는 HashMap을 입력받아 Entry의 개수를 출력합니다.

입력
인자 1 : hashMap
<Integer, Integer> 타입을 요소로 가지는 HashMap

출력
int 타입을 리턴해야 합니다.
입력받은 HashMap의 크기를 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(){{
  put(1, 10);
  put(2, 20);
  put(3, 30);
}};
int output = getSize(hashMap);
System.out.println(output); // --> 3
*/

import java.util.HashMap;

public class Q_17_getSize {
    public static void main(String[] args) {
        Q_17_getSize coplit = new Q_17_getSize();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>() {{
            put(1, 10);
            put(2, 20);
            put(3, 30);
        }};
        int output = coplit.getSize(hashMap);
        System.out.println(output); // --> 3
    }

    public int getSize(HashMap<Integer, Integer> hashMap) {
        return hashMap.size();
    }
}