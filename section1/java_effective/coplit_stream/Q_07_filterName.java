package section1.java_effective.coplit_stream;

/*
filterName

문제
String타입을 요소로 가지는 List를 입력받아 중복을 제거하고 김씨 성을 가진 이름들을 정렬하여 문자열 배열로 리턴해야 합니다.

입력
인자 1 : names
String 타입을 요소로 가지는 List

출력
String 타입을 요소로 가지는 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
입력받은 리스트에 김씨가 없거나, 리스트의 크기가 0인 경우 0을 리턴해야 합니다.
정렬은 사전식 순서로 정렬 되어야 합니다.

입출력 예시
List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "김자바");
String[] output = filterName(names);
System.out.println(output); // {"김자바", "김코딩"};

힌트
stream을 통해 List의 요소를 순회할 수 있습니다.
stream의 중간 연산으로 중복을 제거할 수 있습니다.
stream의 중간 연산으로 정렬을 할 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;

public class Q_07_filterName {
    public static void main(String[] args) {
        Q_07_filterName coplit = new Q_07_filterName();
        List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "김자바");
        String[] output = coplit.filterName(names);
        System.out.println(output); // {"김자바", "김코딩"};
        for (String name : output) {
            System.out.println(name);
        }

    }

    public String[] filterName(List<String> names) {
        String[] output = names.stream()
                .distinct()
                .filter(n -> n.startsWith("김"))
                .sorted()
                .toArray(String[]::new);
        return  output;
    }
}