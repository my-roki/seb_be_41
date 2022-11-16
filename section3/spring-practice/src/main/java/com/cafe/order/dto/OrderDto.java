package com.cafe.order.dto;

import com.cafe.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    @Getter
    public static class Post {
        @Positive
        private long memberId;

        @Valid
        @NotNull(message = "주문할 커피정보를 입력해주세요.")
        private List<OrderCoffeeDto> orderCoffees;

    }

    @Getter
    public static class Patch {
        private long orderId;
        private Order.OrderStatus orderStatus;

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }
    }

    @Getter
    @Setter
    public static class Response {
        private long orderId;
        private long memberId;
        private Order.OrderStatus orderStatus;
        private List<OrderCoffeeResponseDto> orderCoffees;
        private LocalDateTime createdAt;
    }
}