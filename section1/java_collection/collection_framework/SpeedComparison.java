package section1.java_collection.collection_framework;

import java.util.ArrayList;
import java.util.LinkedList;

// TODO 시간 결과값이 이상하게 나온다. 문의해야함
public class SpeedComparison {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        double startTime;
        double endTime;

        // 순차적으로 추가
        System.out.println("---------------------------------------");
        startTime = System.nanoTime();
        for (int i = 1; i <= 10000000; i++)
            arrayList.add(i);
        endTime = System.nanoTime();
        System.out.println("순차적인 추가 - ArrayList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        startTime = System.nanoTime();
        for (int i = 1; i <= 10000000; i++)
            linkedList.add(i);
        endTime = System.nanoTime();
        System.out
                .println("순차적인 추가 - LinkedList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        System.out.println("---------------------------------------");
        startTime = System.nanoTime();
        for (int i = 9999999; i > 5000000; i--)
            arrayList.remove(i);
        endTime = System.nanoTime();
        System.out
                .println("중간 데이터 삭제 - ArrayList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");

        startTime = System.nanoTime();
        for (int i = 9999999; i > 5000000; i--)
            linkedList.remove(i);
        endTime = System.nanoTime();
        System.out.println(
                "중간 데이터 삭제 - linkedList : " + Math.round((endTime - startTime) / 1000000 * 100) / 100.0 + "ms");
    }
}