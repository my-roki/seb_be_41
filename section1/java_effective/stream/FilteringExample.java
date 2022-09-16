package section1.java_effective.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringExample{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("roki", "choki", "chiki", "toki", "chiki");

        System.out.println("### Only distinct ###");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n### Only filter ###");
        names.stream()
                .filter(n->n.startsWith("ch"))
                .forEach(System.out::println);

        System.out.println("\n### Distinct and filter###");
        names.stream()
                .distinct()
                .filter(n->n.startsWith("ch"))
                .forEach(System.out::println);
    }
}