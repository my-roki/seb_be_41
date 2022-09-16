package section1.java_effective.stream;

import java.util.List;

public class DeclarativeProgramingExample {
    public static void main(String[] args) {
        // List에 있는 숫자 중 짝수의 합 구하기
        // 명령형 방식 프로그래밍
        List<Integer> ipNumbers = List.of(1, 3, 6, 4, 7, 8, 13, 20);
        int sum1 = 0;
        for (int number : ipNumbers) {
            if (number % 2 == 0) sum1 += number;
        }
        System.out.println("# Imperative Programming : " + sum1);

        // 선언형 방식 프로그래밍
        List<Integer> dpNumbers = List.of(1, 3, 6, 4, 7, 8, 13, 20);
        int sum2 = dpNumbers
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
        System.out.println("# Declarative Programming : " + sum2);
    }
}