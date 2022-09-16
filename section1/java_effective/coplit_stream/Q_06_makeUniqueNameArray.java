package section1.java_effective.coplit_stream;

/*
makeUniqueNameArray

문제
String 타입을 요소로 가지는 List를 입력받아 중복을 제거하고 정렬한 후 String 타입을 요소로 갖는 배열로 리턴해야 합니다.

입력
인자 1 : names
String 타입을 요소로 가지는 List

출력
String 타입을 요소로 가지는 배열을 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
정렬은 사전식 순서로 정렬 되어야 합니다.

입출력 예시
List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "박해커");
String[] output = makeUniqueNameArray(names);
System.out.println(output); // {"김코딩", "박해커", "최자바"};

힌트
stream을 통해 List의 요소를 순회할 수 있습니다.
stream의 중간 연산으로 중복을 제거할 수 있습니다.
stream의 중간 연산으로 정렬을 할 수 있습니다.
 */

import java.util.*;

public class Q_06_makeUniqueNameArray {
    public static void main(String[] args) {
        Q_06_makeUniqueNameArray coplit = new Q_06_makeUniqueNameArray();
        List<String> names = Arrays.asList("김코딩", "박해커", "김코딩", "최자바", "박해커");
        String[] output = coplit.makeUniqueNameArray(names);
        System.out.println(output); // {"김코딩", "박해커", "최자바"};
    }

    public String[] makeUniqueNameArray(List<String> names) {
        String[] output = names.stream()
                .distinct()
                .sorted()
                .toArray(String[]::new);
        return output;
    }
}