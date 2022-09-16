package section1.java_effective.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class StreamLambdaExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("roki", 95),
                new Student("toki", 92)
        );

        Stream<Student> stream = list.stream();
        stream.forEach(s -> {
            String name = s.getName();
            int score = s.getScore();
            System.out.printf("%s - %d%n", name, score);
        });
    }
}