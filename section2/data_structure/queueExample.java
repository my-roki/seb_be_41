package section2.data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class queueExample {
    public static void main(String[] args) {
        // Queue 이용
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            queue.add(i);
            System.out.printf("First in : %s%n", queue);
        }
        System.out.println("-".repeat(40));

        while (queue.size() != 0) {
            queue.poll();
            System.out.printf("First out : %s%n", queue);
        }
        System.out.println("=".repeat(40));

        // ArrayList 이용
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
            System.out.printf("First in : %s%n", arrayList);
        }
        System.out.println("-".repeat(40));

        while (arrayList.size() != 0) {
            arrayList.remove(0);
            System.out.printf("First out : %s%n", arrayList);
        }
    }
}