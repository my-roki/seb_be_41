package section1.java_effective.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Employee implements Comparable<Employee> {
    int id;
    String name, department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    String getDepartment() {
        return department;
    }

    public String toString() {
        return String.format("[%d, %s, %s]", id, name, department);
    }

    public int compareTo(Employee e) {
        return e.id - this.id;
    }

}

public class ComparatorExample {
    public static void main(String[] args) {
        List<String[]> stringList = List.of(
                new String[]{"hello", "world", "java"},
                new String[]{"code", "states"});

        System.out.println("### Map ###");
        stringList.stream()
                .map(Arrays::stream)
                .forEach(System.out::println);

        System.out.println("\n### flatMap ###");
        stringList.stream()
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        List<String> list = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

        System.out.println("\n### Sort ###");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n### Reverse sort ###");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("\n### Comparing key sort ###");
        Stream<Employee> workersStream =
                Stream.of(new Employee(11, "roki", "Software Engineering"),
                        new Employee(5, "toki", "Growth Marketing"),
                        new Employee(7, "poki", "Software Engineering"));
        workersStream.sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);
    }
}