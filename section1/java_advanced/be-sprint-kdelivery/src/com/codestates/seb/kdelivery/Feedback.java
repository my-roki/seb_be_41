package com.codestates.seb.kdelivery;

public class Feedback {
  private String customerName;
  private String shopName;
  private String foodName;
  private int grade;

  /**
   * @Feedback() : 정보를 저장합니다
   */
  Feedback(String customerName, String shopName, String foodName, int grade) {
      this.customerName = customerName;
      this.shopName = shopName;
      this.foodName = foodName;
      this.grade = grade;
  }

  /**
   * @getStars() : 사용자가 입력한 점수가 별점으로 전환
   */
  public String getStars(int grade) {
      return "★".repeat(grade);
  }

  /**
   * @printInfo() : 출력
   */
  public void printInfo() {
      System.out.printf("%s [고객님]%n", customerName);
      System.out.println("-------------------------");
      System.out.printf("주문 매장 : %s%n", shopName);
      System.out.printf("주문 메뉴 : %s%n", foodName);
      System.out.printf("별점 : %s%n%n", getStars(grade));
  }
}
