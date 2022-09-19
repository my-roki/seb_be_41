package com.codestates.seb.calculator;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        /*
            요구 사항에 따라 간단한 계산기를 만들어주세요.
            1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            2. 연산자의 종류는 +, -, *, / 입니다.
            3. 소수점 연산을 수행할 수 있어야 합니다.
            4. 연산 결과를 콘솔에 출력합니다.
        */
    // TODO...
    // The calculator run infinitely while user says no.
    boolean playing = true;
    double number1 = 0;
    double number2 = 0;
    String operator = "";

    while (playing){
      System.out.println("===Java Calculator===");

      // Set First number
      boolean isFirst = true;
      while (isFirst) {
        try {
          System.out.print("Choose first number : ");
          number1 = Double.parseDouble(input.nextLine());
          isFirst = false;
        } catch (Exception e) {
          System.out.println("Please write correct number.");
        }
      }

      // Set operator
      boolean isOperator = true;
      while (isOperator) {
        System.out.print("Choose an operation\n" +
                "     (+ , - , *, /) : ");
        operator = input.nextLine();
        if (Objects.equals(operator, "+") || Objects.equals(operator, "-") ||
                Objects.equals(operator, "*") || Objects.equals(operator, "/")) {
          isOperator=false;
        } else {
          System.out.println("Please select correct operator.");
        }
      }

      // Set second number
      boolean isSecond = true;
      while (isSecond) {
        try {
          System.out.print("Choose second number : ");
          number2 = Double.parseDouble(input.nextLine());
          isSecond = false;
        } catch (Exception e) {
          System.out.println("Please write correct number.");
        }
      }

      // Calculate and print result according to the operator user input
      double result = 0;
      if (Objects.equals(operator, "+")) result = number1 + number2;
      if (Objects.equals(operator, "-")) result = number1 - number2;
      if (Objects.equals(operator, "*")) result = number1 * number2;
      if (Objects.equals(operator, "/")) result = number1 / number2;
      System.out.printf("Result : %f%n", result);

      // Ask to user playing again
      boolean correct = true;
      while (correct) {
        System.out.print("Do you want to play again? [y/N] ");
        String again = input.nextLine();
        if (again.equals("N")) {
          System.out.println("Bye~");
          playing = false;
          correct = false;
        } else if (again.equals("y")) {
          correct = false;
        } else {
          System.out.println("Invalid answer!");
        }

        // Clear the console (Only terminal not IDE console)
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    }
  }
}
