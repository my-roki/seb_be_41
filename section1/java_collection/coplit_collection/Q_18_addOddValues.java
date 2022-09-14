package section1.java_collection.coplit_collection;

/* 
addOddValues

문제
<Character, Integer> 타입을 요소로 가지는 HashMap을 입력받아 짝수 값(Value) 끼리 모두 더한 값을 리턴해야 합니다.

입력
인자 1 : hashMap
<Character, Integer> 타입을 요소로 가지는 HashMap

출력
int 타입의 짝수 Value들의 총합을 리턴해야 합니다.

입출력 예시
HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(){{
	put('a', 1);
	put('b', 4);
	put('c', 6);
	put('d', 9);
}};
int output = addOddValues(hashMap);
System.out.println(output); // --> 10

힌트
HashMap이 제공해주는 메서드를 통해 저장되어있는 Key 모음(keySet)에 바로 접근할 수 있습니다.
*/

import java.util.HashMap;

public class Q_18_addOddValues {
    public static void main(String[] args) {
        Q_18_addOddValues coplit = new Q_18_addOddValues();
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{
            put('a', 1);
            put('b', 4);
            put('c', 6);
            put('d', 9);
        }};
        int output = coplit.addOddValues(hashMap);
        System.out.println(output); // --> 10
    }

    public int addOddValues(HashMap<Character, Integer> hashMap) {
        int output = 0;
        for (Character key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            if (value % 2 == 0) output += value;
        }
        return  output;
    }
}