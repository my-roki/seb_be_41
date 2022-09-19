package com.codestates.seb.Ai_V3;

public class Ai_V3 {
  public static void main(String[] args) {
    // TODO:
    /*
     * 프로그램에 필요한 변수 선언
     * xy_lists : 데이터를 담을 2차원 배열
     * diff : 편차
     * diff_pow : 편차의 제곱(double)
     * diff_pow_float : 편차의 제곱(float)
     * sum_diff_pow : 편차 제곱의 합
     */

    // 프로그램 안내 문구 출력
    System.out.println("[인공지능 프로그램 V3]");
    System.out.println("==============================");

    // 1단계 2차원 배열 데이터 생성
    double[][] xy_lists = new double[][] { { 374, 1161 }, { 385, 1401 }, { 375, 1621 }, { 401, 1681 } };

    // 데이터 출력 안내 문구 생성
    System.out.println("[안내] 인공지능 프로그램에 할당된 데이터");
    for (int i = 0; i < xy_lists.length; i++) {
      System.out.println(String.format("%d번 째 데이터) [실제값] 웹 페이지 방문자 수 : %.1f	[인공지능 예측값] 웹 페이지 방문자 수 : %.1f", i + 1,
          xy_lists[i][0], xy_lists[i][1]));
    }

    // 2단계, 3단계
    // 배열 속 값을 호출하며 편차 -> 제곱 -> 합산 과정을 수행합니다.
    double sum_diff_pow = 0;
    for (int i = 0; i < xy_lists.length; i++) {
      double diff = xy_lists[i][0] - xy_lists[i][1];
      double diff_pow = Math.pow(diff, 2);

      System.out.println(String.format("\n[%d 번째 데이터] 실제 값과 예측값의 오차 : %.1f", i + 1, diff));
      System.out.println(String.format("[안내] 오차의 제곱 : %.1f", diff_pow));
      sum_diff_pow += diff_pow;
    }
    System.out.println("\n==============================");
    System.out.println(String.format("[안내] 인공지능 프로그램의 성능(오차의 제곱 합) : %.1f", sum_diff_pow));
  }
}
