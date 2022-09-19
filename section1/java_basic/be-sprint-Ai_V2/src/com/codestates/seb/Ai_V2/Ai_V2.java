package com.codestates.seb.Ai_V2;

import java.util.Scanner;

/**
 * 해당 프로그램은 예측에 필요한 a, b를 사용자가 입력하도록 합니다.
 * 해당 프로그램은 하나의 값이 아닌 다수의 값을 입력받고 다수의 예측을 수행하도록 합니다.
 */
public class Ai_V2 {
  public static void main(String[] args) {
    /*
     * 인공지능 예측에 필요한 변수를 정의합니다.
     * a,b : 예측에 필요한 요소
     * x_list : 예측에 필요한 광고비 배열
     * y : 예측한 결과값(웹 페이지 방문자 수)
     * y_list :
     */

    // TODO:

    // 사용자의 입력을 받기 위한 Scanner 객체를 생성합니다.
    Scanner scanner = new Scanner(System.in);

    // 시스템 시작 안내 문구
    System.out.println("[인공지능 프로그램 V2]");
    System.out.println("====================================");
    System.out.print("[System] a 값을 입력하여 주세요 : ");
    int a = scanner.nextInt();
    System.out.print("[System] b 값을 입력하여 주세요 : ");
    int b = scanner.nextInt();
    System.out.println("====================================");

    // 이전 버전과 달리 다수의 '광고비'를 '배열'로 정의합니다.
    double[] x_lists = new double[] { 580, 700, 810, 840 };

    // 반복문을 활용하여 광고비 배열을 출력합니다.
    System.out.println("\n[안내] 입력된 '광고비'는 다음과 같습니다.");
    for (int i = 0; i < x_lists.length; i++) {
      System.out.print(String.format("%d 번째) %.1f원  ", i + 1, x_lists[i]));
    }

    // 한 줄 띄기 및 예측 결과 안내 문구 출력
    System.out.println("\n\n[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");

    // 반복문을 활용해 다수의 광고비(x_list)를 호출하여 방문자 수 예측값을 연산합니다.
    for (int i = 0; i < x_lists.length; i++) {
      double visitor = (a * x_lists[i]) + b;
      System.out.println(String.format("%d 번째 예측) %.1f회 방문", i + 1, visitor));
    }
  }
}