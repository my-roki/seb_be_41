package section1.java_collection.coplit_collection;

/* 
getElementOfListEntry

문제
HashMap, key, 인덱스를 입력받아 주어진 키에 해당하는 값이 List인 경우, 수가 가리키는 인덱스에 해당하는 요소를 리턴해야 합니다.

입력
인자 1 : hashMap
<String, List<String>> 타입을 요소로 갖는 HashMap
인자 2 : key
임의의 문자열
인자 3 : index
List의 인덱스 (0 이상의 정수)

출력
String 타입의 List의 요소를 리턴해야 합니다.

주의 사항
입력 인자 hashMap의 경우 key는 String 타입, value는 String 타입을 요소로 갖는 List 입니다.
주어진 수가 List의 범위를 벗어나지 않는 경우에만 List의 요소를 리턴해야 합니다.
그 외의 경우, null를 리턴해야 합니다.

입출력 예시
HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>(){{
	put("apple", Arrays.asList("apple", "red"));
	put("banana", Arrays.asList("delicious"));
}};
String output = getElementOfListEntry(hashMap, "apple", 1);
System.out.println(output); // --> "red"
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q_21_getElementOfListEntry {
    public static void main(String[] args) {
        Q_21_getElementOfListEntry coplit = new Q_21_getElementOfListEntry();
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>() {{
            put("apple", Arrays.asList("apple", "red"));
            put("banana", Arrays.asList("delicious"));
        }};
        String output = coplit.getElementOfListEntry(hashMap, "apple", 1);
        System.out.println(output); // --> "red"

    }

    public String getElementOfListEntry(HashMap<String, List<String>> hashMap, String key, int index) {
        List<String> value = hashMap.get(key);
        if (value == null) return null;
        if (value.size() <= index) return null;
        return value.get(index);
    }
}