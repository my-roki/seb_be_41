package com.codestates.seb.fibonacci;

import java.util.Scanner;
import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    // 1단계. 프로그램 시작을 알리는 출력문 선언
    System.out.println("[안내]피보나치 수열 프로그램 시작.");

    // 사용자의 입력값 받기.
    int fibCount = getUserInput();

    // 2단계. 피보나치 수열의 점화식 코드 작성
    // 피보나치 수열의 첫 번째와 두 번째 값을 변수로 정의합니다.
    int fib1 = 1;
    int fib2 = 1;

    // 피보니치 수열이 저장될 배열 객체 선언
    // 사용자 입력값이 1 이하일 때 index error 방지 차원에서,
    // 최소 길이기 2인 배열을 만든 후 나중에 배열 길이를 늘려가는 방법으로 리팩토링
    int[] fibArr = new int[2];
    fibArr[0] = fib1;
    fibArr[1] = fib2;

    // 반복문을 통한 피보나치 수열 점화식 작성
    // 해당 점화식은 첫 번째와 두 번째는 구할 필요 없기에 이를 고려한 반복문의 조건식을 작성합니다.
    // 피보나치 수열의 점화식은 n+2번 째 부터 구현.
    // 피보나치 수열의 n+2번 째 값은 (n + n+1)를 통해 구할 수 있습니다.
    fibArr = getFibonacci(fibArr, fibCount);

    // 3단계.
    // 결과 출력을 위한 안내 문구 출력 입니다.
    // 피보나치 수열은 fibonacci 배열에 들어가 있기에 이를 반복문을 통해 호출
    printNumbers(fibArr);
  }

  public static int getUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
    int fibCount = scanner.nextInt();
    return fibCount;
  }

  public static int[] getFibonacci(int[] fibArr, int fibCount) {
    for (int i = 0; i < fibCount; i++) {
      if (i < 2) {
        continue;
      }
      int fibn = fibArr[i - 1] + fibArr[i - 2];
      fibArr = Arrays.copyOf(fibArr, fibArr.length + 1);
      fibArr[i] = fibn;
    }
    return fibArr;
  }

  public static void printNumbers(int[] fibArr) {
    System.out.println("[피보나치 수열 출력]");
    for (int fibn : fibArr) {
      System.out.println(fibn);
    }
    System.out.println("[안내]프로그램을 종료합니다.");
  }
}