package section1.java_effective.coplit_stream;

/*
computeAverageOfNumbers

문제
Integer 타입을 요소로 가지는 List를 입력받아 요소의 평균을 리턴해야합니다.

입력
인자 1 : list
Integer 타입을 요소로 가지는 List

출력
double 타입을 리턴해야 합니다.

주의 사항
비어있는 List의 경우 0을 리턴해야 합니다.
반복문(for, while) 사용은 금지됩니다.

입출력 예시
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
double output = computeAverageOfNumbers(list);
System.out.println(output); // --> 3

힌트
stream을 통해 List의 요소를 순회할 수 있습니다.
 */

import java.util.Arrays;
import java.util.List;

public class Q_02_computeAverageOfNumbers {
    public static void main(String[] args) {
        Q_02_computeAverageOfNumbers coplit = new Q_02_computeAverageOfNumbers();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        double output = coplit.computeAverageOfNumbers(list);
        System.out.println(output); // --> 3

    }

    public double computeAverageOfNumbers(List<Integer> list) {
        double output = list.stream()
                .mapToDouble(n -> n)
                .average()
                .orElse(0);
        return output;
    }
}