package section1.java_collection.collection_framework;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {

        // HashSet 생성
        HashSet<String> languages = new HashSet<String>();

        // HashSet에 객체 추가
        languages.add("Java");
        languages.add("Python");
        languages.add("Javascript");
        languages.add("C++");
        languages.add("Kotlin");
        languages.add("Ruby");
        languages.add("Java"); // 중복

        // 반복자 생성하여 it에 할당
        Iterator it = languages.iterator();

        // 반복자를 통해 HashSet을 순회하며 각 요소들을 출력
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}