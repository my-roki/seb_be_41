package com.codestates.seb.kiosk_program;

import com.codestates.seb.kiosk_program.Kiosk_Program;

public class Kiosk_Start {

    /**
     * @main() 메서드 동작
     *         프로그램 실행 -> 메뉴 입력 -> 수량 입력 및 가격 계산 -> 가격 출력
     */
    public static void main(String[] args) {
        // TODO:
        Kiosk_Program program = new Kiosk_Program();
        program.input_print();
        int number = program.count();
        program.cost(number);
        int result = number * Kiosk_Program.amount;
        program.output_print(result);
    }
}
