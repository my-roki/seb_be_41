package section1.java_collection.collection_framework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {

        // HashMap 생성
        HashMap<String, Integer> map = new HashMap<>();

        // Entry 객체 저장
        map.put("피카츄", 85);
        map.put("꼬부기", 95);
        map.put("야도란", 75);
        map.put("파이리", 65);
        map.put("피존투", 15);

        // 저장된 총 Entry 수 얻기
        System.out.println("총 entry 수: " + map.size());

        // 객체 찾기
        System.out.println("파이리 : " + map.get("파이리"));

        // key를 요소로 가지는 Set을 생성 -> 아래에서 순회하기 위해 필요합니다.
        Set<String> keySet = map.keySet();

        // keySet을 순회하면서 value를 읽어옵니다.
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println(key + " : " + value);
        }

        // 객체 삭제
        map.remove("피존투");

        System.out.println("총 entry 수: " + map.size());

        // Entry 객체를 요소로 가지는 Set을 생성 -> 아래에서 순회하기 위해 필요합니다.
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        // entrySet을 순회하면서 value를 읽어옵니다.
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey(); // Map.Entry 인터페이스의 메서드
            Integer value = entry.getValue(); // Map.Entry 인터페이스의 메서드
            System.out.println(key + " : " + value);
        }

        // 객체 전체 삭제
        map.clear();
    }
}

