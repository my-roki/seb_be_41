package section1.java_effective.coplit_stream;

/*
findPeople

문제
남성 회원 이름의 List와 여성 회원 이름의 List가 있습니다.
남성 회원과 여성 회원 중 특정 성씨를 갖고 있는 사람의 명단이 필요합니다.
중복된 이름은 제거하고 특정 성씨를 갖고 있는 회원들의 이름을 정렬한 후 List로 리턴해야 합니다.

입력
인자 1 : male
String 타입을 요소로 가지는 List
인자 2 : female
String 타입을 요소로 가지는 List
인자 3 : lastName
String 타입의 변수

출력
String 타입을 요소로 가지는 List를 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
일치하는 회원이 없는 경우 비어있는 List를 리턴해야 합니다.
중복 요소는 허용하지 않습니다.
사전식 순서로 정렬이 필요합니다.

입출력 예시
List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
List<String> output = findPeople(male, female, "김");
System.out.println(output); // ["김유클", "김코딩", "김코츠"]

힌트
각 리스트의 스트림을 생성한 후 두 개의 스트림을 하나로 붙일 수(concatenate) 있습니다.
stream을 통해 List의 요소를 순회할 수 있습니다.
stream의 중간 연산으로 중복을 제거할 수 있습니다.
stream의 중간 연산으로 정렬을 할 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q_13_findPeople {
    public static void main(String[] args) {
        Q_13_findPeople coplit = new Q_13_findPeople();
        List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        List<String> output = coplit.findPeople(male, female, "김");
        System.out.println(output); // ["김유클", "김코딩", "김코츠"]
    }

    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        Stream<String> maleStream = male.stream();
        Stream<String> femaleStream = female.stream();

        Stream<String> allStream = Stream.concat(maleStream, femaleStream);
        List<String> output = allStream
                .distinct()
                .filter(n -> n.startsWith(lastName))
                .sorted()
                .collect(Collectors.toList());

        return output;

    }
}