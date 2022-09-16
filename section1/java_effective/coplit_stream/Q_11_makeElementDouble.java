package section1.java_effective.coplit_stream;

/*
makeElementDouble

문제
Integer 타입을 요소로 가지는 List를 입력받아 각 요소에 2를 곱한 새로운 List를 리턴해야 합니다.

입력
인자 1 : list
Integer 타입을 요소로 가지는 List

출력
Integer 타입을 요소로 가지는 List를 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.
비어있는 리스트를 입력받은 경우, 비어있는 리스트를 리턴해야 합니다.

입출력 예시
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> output = makeElementDouble(list);
System.out.println(output); // [2, 4, 6, 8, 10]

힌트
Stream을 통해 List를 순회하며 각 요소에 동일한 연산을 반복할 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q_11_makeElementDouble {
    public static void main(String[] args) {
        Q_11_makeElementDouble coplit = new Q_11_makeElementDouble();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = coplit.makeElementDouble(list);
        System.out.println(output); // [2, 4, 6, 8, 10]

    }

    public List<Integer> makeElementDouble(List<Integer> list) {
        List<Integer> output = list.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        return output;
    }
}