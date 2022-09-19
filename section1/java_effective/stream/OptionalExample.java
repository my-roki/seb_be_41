package section1.java_effective.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("roki", "toki", "poki", "choki", "chiki");
        Optional<List<String>> listOptional = Optional.of(list);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        System.out.println(size);
    }
}