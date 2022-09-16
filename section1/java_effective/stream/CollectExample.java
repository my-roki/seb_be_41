package section1.java_effective.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Students {
    public enum Gender {Male, Female}

    ;
    private String name;
    private int score;
    private Gender gender;

    public Students(String name, int score, Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class CollectExample {
    public static void main(String[] args) throws Exception {
        List<Students> totalList = Arrays.asList(
                new Students("roki", 10, Students.Gender.Male),
                new Students("toki", 8, Students.Gender.Male),
                new Students("poki", 9, Students.Gender.Female),
                new Students("koki", 10, Students.Gender.Female)
        );

        System.out.println("\n### Male ###");
        List<Students> maleList = totalList.stream()
                .filter(s -> s.getGender() == Students.Gender.Male)
                .collect(Collectors.toList());
        maleList.forEach(n -> System.out.printf("%s ", n.getName()));

        System.out.println("\n### Female ###");
        Set<Students> femaleSet = totalList.stream()
                .filter(s -> s.getGender() == Students.Gender.Female)
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.forEach(n -> System.out.printf("%s ",n.getName()));
    }
}