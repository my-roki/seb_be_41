package com.codestates.helper;

import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;

import java.util.List;

public class StampCalculatorWithoutJUnit {
    public static void main(String[] args) {
        calculateStampCountTest();
        calculateEarnedStampCountTest();
    }

    private static void calculateStampCountTest() {
        // given
        // 테스트를 위한 준비과정
        // 테스트에 필요한 전제조건, 전달되는 입력값 등
        int nowCount = 5;
        int earned = 3;

        // when
        // 테스트 할 대상, 메서드 호출 부분
        int actual = StampCalculator.calculateStampCount(nowCount, earned);
        int expected = 7;

        // then
        // 테스트의 결과를 검증, Assertion code
        System.out.printf("Test calculateStampCount: %s%n", actual == expected);
    }

    private static void calculateEarnedStampCountTest() {
        // given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        // when
        int actual = StampCalculator.calculateEarnedStampCount(order);

        // then
        System.out.printf("Test calculateEarnedStampCount: %s%n", expected == actual);
    }
}