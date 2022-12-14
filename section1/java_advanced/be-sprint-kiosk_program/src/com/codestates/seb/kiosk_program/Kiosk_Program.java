package com.codestates.seb.kiosk_program;

import java.util.Scanner;

// Kiosk_Program 클래스를 정의 합니다.
public class Kiosk_Program {
  // TODO:
  // 메뉴 입력 및 사용자의 수량을 입력하기 위해 Scanner 객체 생성
  static Scanner sc = new Scanner(System.in);
  /**
   * @menu_n_cost : 메뉴의 가격을 정의 합니다.
   *              메뉴의 가격은 변하지 않습니다.
   *              해당 기능은 자바독(javadoc) 기능입니다.
   */
  // TODO:
  static final int menu_1_cost = 1000;
  static final int menu_2_cost = 1500;
  static final int menu_3_cost = 1000;
  static final int menu_4_cost = 2000;
  static int amount = 0;

  /**
   * 프로그램의 시작을 알리는 메서드입니다.
   * @.repeat() 메서드는 해당 문자를 반복해서 출력해주는 기능을 갖습니다.
   */
  public void input_print() {
    // TODO:
    System.out.println("[안내]안녕하세요. 김밥천국에 오신 것을 환영합니다.");
    System.out.println("------------------------------");
  }

  /**
   * 사용자가 원하는 메뉴를 번호로 입력받습니다.
   * 
   * @재귀함수 : 본 메서드가 동작할 때 메뉴에 없는 번호가 입력되면 자기 자신이 다시 실행되도록 합니다.
   *       해당 count() 메소드는 기능이 모두 구현되어 있습니다. Scanner 객체의 변수명만 확인해야 합니다.
   */
  public int count() {
    System.out.println("[안내]원하시는 메뉴의 번호를 입력하여 주세요.");
    System.out.printf(
        "1) 김밥(%d원) 2) 계란 김밥(%d원) 3) 충무 김밥(%d원) 4) 떡볶이(%d원)%n",
        menu_1_cost, menu_2_cost, menu_3_cost, menu_4_cost);
    // sc == 최 상단에 입력받은 Scanner 객체
    // 변수명이 다르다면 하단의 이름을 수정해야 합니다.
    int number = sc.nextInt(10);

    // 만약 사용자가 입력한 번호의 조건이 아래와 같다면,
    // 0 이하의 조건
    // 4 초과의 조건
    // 둘 중 하나라도 참 인경우 참의 값을 반환
    if (number <= 0 || number > 4) {
      // [경고] 문구를 출력합니다.
      System.out.println("[경고]메뉴에 포함된 번호를 입력하여 주세요.\n");
      // 그리고 다시 본 함수가 동작하여 다시 메뉴의 번호를 입력하도록 합니다.

      // java의 재귀함수 호출 방법 : https://lts0606.tistory.com/509
      return count();
    }

    // System.out.printf("number : %d%n", number);

    // 이후 가격 연산을 위해
    // 가격(menu_n_cost)을 number 변수에 재할당 합니다.
    if (1 == number) {
      number = menu_1_cost;
    } else if (2 == number) {
      number = menu_2_cost;
    } else if (3 == number) {
      number = menu_3_cost;
    } else {
      number = menu_4_cost;
    }
    return number;
  }

  /**
   * 수량 입력 및 가격 연산을 진행하는 메서드를 정의합니다.
   * 
   * @수량 : 수량은 1 ~ 99 까지만 입력 받을 수 있도록 합니다.
   */
  public void cost(int number) {
    // 안내 문구를 출력합니다.
    // TODO:
    System.out.println("[안내]선택하신 메뉴의 수량을 입력하여 주세요.");
    System.out.println("(※ 최대 주문 가능 수량 : 99)");

    // 입력받은 수량을 변수에 저장합니다.
    // TODO:
    amount = sc.nextInt();

    // 조건에 따라 문구 출력, 재입력을 진행합니다.
    // 조건은 다음과 같습니다.
    // 0 이하 || 99 초과
    // 두 조건 중 하나라도 참인경우 경고 문구 출력과 함께 다시 수량을 입력받을 수 있도록 합니다.
    // TODO:
    if (amount <= 0 || amount > 99) {
      System.out.printf("[경고]%d개는 입력하실 수 없습니다.", amount);
      System.out.println("[경고]수량 선택 화면으로 돌아갑니다.");
      System.out.println("------------------------------");
      cost(number);
    }
  }

  /**
   * 최종 가격과 종료 문구를 출력하는 메서드 입니다.
   */
  public void output_print(int result) {
    // TODO:
    System.out.printf("[안내]주문하신 메뉴의 총 금액은%d원 입니다.%n", result);
    System.out.println("[안내]이용해 주셔서 감사합니다.");
  }
}
