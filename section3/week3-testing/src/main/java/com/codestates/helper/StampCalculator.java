package com.codestates.helper;

import com.codestates.order.entity.Order;

public class StampCalculator {
    // 보유한 스탬프 수와 회원이 주문한 커피 수량 만큼 획득한 스탬프 수를 더해서 누적 스탬프 수를 계산
    public static int calculateStampCount(int nowCount, int earned) {
        return nowCount + earned;
    }

    // 회원이 주문한 주문 정보에서 얻게되는 스탬프 개수를 계산
    public static int calculateEarnedStampCount(Order order) {
        return order.getOrderCoffees().stream()
                .map(orderCoffee -> orderCoffee.getQuantity())
                .mapToInt(quantity -> quantity)
                .sum();
    }
}