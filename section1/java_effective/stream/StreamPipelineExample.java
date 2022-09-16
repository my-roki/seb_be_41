package section1.java_effective.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Member {
    public enum Gender {Male, Female}

    ;
    private String name;
    private Gender gender;
    private int age;

    public Member(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("roki", Member.Gender.Male, 29),
                new Member("toki", Member.Gender.Female, 24),
                new Member("poki", Member.Gender.Female, 33),
                new Member("koki", Member.Gender.Male, 18)
        );

        // Pipeline full code
        Stream<Member> maleFemaleStream = list.stream();
        Stream<Member> maleStream = maleFemaleStream.filter(m -> m.getGender() == Member.Gender.Male);
        IntStream ageStream = maleStream.mapToInt(Member::getAge);
        OptionalDouble opd = ageStream.average();
        double averageFullCode = opd.getAsDouble();
        System.out.printf("All male average age is : %.1f%n", averageFullCode);

        // Pipeline short code
        double averageShortCode = list.stream()
                .filter(m -> m.getGender() == Member.Gender.Male)
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();
        System.out.printf("All male average age is : %.1f%n", averageShortCode);

    }
}
















