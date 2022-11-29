package com.codestates;

import java.util.List;

public class ImperativeProgrammingExample {
    public static void main(String[] args) {
        // List에 있는 숫자들 중에서 4보다 큰 짝수의 합계를 구하기
        List<Integer> numbers = List.of(1, 3, 6, 7, 8, 11);

        int sum = 0;
        for (int number : numbers) {
            if (number > 4 && number % 2 == 0) {
                sum += number;
            }
        }

        System.out.printf("Imperative Programming: %d%n", sum);
    }
}