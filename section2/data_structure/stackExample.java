package section2.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class stackExample {
    public static void main(String[] args) {
        // Stack 이용
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.printf("First in : %s%n", stack);
        }
        System.out.println("-".repeat(40));

        while (stack.size() != 0) {
            stack.pop();
            System.out.printf("Last out : %s%n", stack);
        }
        System.out.println("-".repeat(40));

        // ArrayList 이용
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
            System.out.printf("First in : %s%n", arrayList);
        }
        System.out.println("-".repeat(40));

        while (arrayList.size() != 0) {
            arrayList.remove(arrayList.size()-1);
            System.out.printf("Last out : %s%n", arrayList);
        }
    }
}