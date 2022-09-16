package section1.java_effective.coplit_stream;

/*
filterOddNumbers

문제
Integer 타입을 요소로 가지는 List를 입력받이 짝수 요소만 추출한 List를 리턴해야 합니다.

입력
인자 1 : list
Integer 타입을 요소로 가지는 List

출력
Integer타입을 요소로 가지는 List를 리턴해야 합니다.

주의 사항
반복문(for, while) 사용은 금지됩니다.

입출력 예시
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> output = computeAverageOfNumbers(list);
System.out.println(output); // --> [2, 4]

힌트
stream을 통해 List의 요소를 순회할 수 있습니다.
특정 조건에 맞는 요소만 구해야할 때, filter를 이용하면 반복문과 조건문을 대체할 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q_03_filterOddNumbers {
    public static void main(String[] args) {
        Q_03_filterOddNumbers coplit = new Q_03_filterOddNumbers();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = coplit.filterOddNumbers(list);
        System.out.println(output); // --> [2, 4]
    }

    public List<Integer> filterOddNumbers(List<Integer> list) {
        List<Integer> output = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        return output;
    }
}