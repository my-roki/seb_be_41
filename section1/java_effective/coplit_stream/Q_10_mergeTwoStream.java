package section1.java_effective.coplit_stream;

/*
문제
String 타입을 요소로 가지는 List 두 개를 입력받아, 스트림을 이용해 하나의 List로 합친 결과를 리턴해야 합니다.

입력
인자 1 : list1
String 타입을 요소로 가지는 List
인자 2 : list2
String 타입을 요소로 가지는 List

출력
String 타입을 요소로 가지는 List를 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
List<String> list1 = Arrays.asList("김코딩", "박해커");
List<String> list2 = Arrays.asList("최자바", "이스프링");
List<String> output = mergeTwoStream(list1, list2);
System.out.println(output); // ["김코딩", "박해커", "최자바", "이스프링"]

힌트
각 리스트의 스트림을 생성한 후 두 개의 스트림을 하나로 붙일 수(concatenate) 있습니다.
Stream의 최종 연산 단계에서 리스트의 형태로 만들 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q_10_mergeTwoStream {
    public static void main(String[] args) {
        Q_10_mergeTwoStream coplit = new Q_10_mergeTwoStream();
        List<String> list1 = Arrays.asList("김코딩", "박해커");
        List<String> list2 = Arrays.asList("최자바", "이스프링");
        List<String> output = coplit.mergeTwoStream(list1, list2);
        System.out.println(output); // ["김코딩", "박해커", "최자바", "이스프링"]
    }

    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }
}
