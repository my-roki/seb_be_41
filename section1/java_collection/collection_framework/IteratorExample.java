package section1.java_collection.collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {     // 읽어올 다음 객체가 있다면
            String str = iterator.next(); // next()를 통해 다음 객체를 읽어옵니다.
            System.out.println(str);
        }

        // Replace with enhanced 'for'
        for (String str : list) {
            System.out.println(str);
        }
    }
}