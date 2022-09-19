package com.codestates.seb.lol_program;

public class LOL_Program {
  public static void main(String[] args) {
    // TODO:
    System.out.println("[안내] TRPG 스타크래프트 시작합니다.");

    System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
    LoL_char me = new LoL_char();
    String[] myChar = me.user_create();

    System.out.println("");
    me.user_print(myChar);
    System.out.println("========================================");

    System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
    LoL_char you = new LoL_char();
    String[] yourChar = you.user_create();

    System.out.println("");
    me.user_print(yourChar);
    System.out.println("========================================");

    int[] myChar_int = me.user_info_int(myChar);
    int[] yourChar_int = you.user_info_int(yourChar);
    me.attack(myChar_int, yourChar_int);
  }
}