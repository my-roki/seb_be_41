package section1.java_collection.collection_framework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList를 생성하여 list에 할당
        List<String> list = new ArrayList<String>();

        // String 타입의 데이터를 ArrayList에 추가
        list.add("roki");
        list.add("toki");
        list.add("poki");

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.printf("List size : %d%n", size);

        // 0번째 인덱스의 객체 얻기
        String first = list.get(0);
        System.out.printf("First object : %s%n", first);

        // 저장된 총 객체 수만큼 조회
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.printf("%d : %s%n", i, str);
        }

        // for-each문으로 순회
        for (String str : list) {
            System.out.println(str);
        }

        // 0번 인덱스 객체 삭제
        System.out.println("Before delete first : " + list.get(0));
        list.remove(0);
        System.out.println("After delete first : " + list.get(0));
    }
}
