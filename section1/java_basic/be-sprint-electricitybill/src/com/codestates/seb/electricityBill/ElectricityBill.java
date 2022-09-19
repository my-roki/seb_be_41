package com.codestates.seb.electricityBill;

import java.text.DecimalFormat;

public class ElectricityBill {
  public static void main(String[] args) {
    System.out.println("=".repeat(25));
    System.out.println(" 주택용 전기요금(저압) 계산기 ");
    System.out.println("=".repeat(25));

    // TODO:
    // 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)
    // 2, 100 이하인 경우 전력당 60.7원 부과, 100 초과인 경우 125.9원 부과 (사용한 전력이 100 kWh 초과일 경우)
    int[] usages = new int[] { 77, 184, 211, 343, 466, 515 };
    for (int usage : usages) {
      int cost = calculator(usage);
      DecimalFormat df = new DecimalFormat("###,###");
      String money = df.format(cost);
      System.out.println(String.format("%dkWh의 전기 요금은 %s원 입니다.", usage, money));
    }
  }

  public static int calculator(int usage) {
    double result = 0;
    if (usage > 500) {
      int over500 = usage - 500;
      result += 670.6;
      usage = usage - over500;
    }
    if (usage > 400) {
      int over400 = usage - 400;
      result += over400 * 417.7;
      usage = usage - over400;
    }
    if (usage > 300) {
      int over300 = usage - 300;
      result += over300 * 280.6;
      usage = usage - over300;
    }
    if (usage > 200) {
      int over200 = usage - 200;
      result += over200 * 187.9;
      usage = usage - over200;
    }
    if (usage > 100) {
      int over100 = usage - 100;
      result += over100 * 125.9;
      usage = usage - over100;
    }
    result += usage * 60.7;
    int cost = (int) result; // 원단위 절삭

    int vat = (int) Math.round(cost * 0.1); // 부가가치세, 원단위 미만 4사5입
    int electricInfraFund = (int) Math.floor(((cost * 0.037) / 10) * 10); // 전력산업기반기금, 10원 미만 절사
    int totalAmount = cost + vat + electricInfraFund;

    return totalAmount;
  }
}
