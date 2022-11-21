package com.cafe.order.mapper;

import com.cafe.coffee.entity.Coffee;
import com.cafe.member.entity.Member;
import com.cafe.order.dto.OrderCoffeeResponseDto;
import com.cafe.order.dto.OrderDto;
import com.cafe.order.entity.Order;
import com.cafe.order.entity.OrderCoffee;

import java.util.List;
import java.util.stream.Collectors;

public interface OrderMapper_v2 {
    Order orderPatchDtoToOrder(OrderDto.Patch orderPatchDto);

    default Order orderPostDtoToOrder(OrderDto.Post orderPostDto) {
        Order order = new Order();
        Member member = new Member();
        member.setMemberId(orderPostDto.getMemberId());

        List<OrderCoffee> orderCoffees = orderPostDto.getOrderCoffees().stream()
                .map(orderCoffeeDto -> {
                    OrderCoffee orderCoffee = new OrderCoffee();
                    Coffee coffee = new Coffee();
                    coffee.setCoffeeId(orderCoffeeDto.getCoffeeId());
                    orderCoffee.setQuantity(orderCoffeeDto.getQuantity());
                    orderCoffee.setOrder(order);
                    orderCoffee.setCoffee(coffee);
                    return orderCoffee;
                }).collect(Collectors.toList());

        order.setMember(member);
        order.setOrderCoffees(orderCoffees);

        return order;
    }

    default OrderDto.Response orderToOrderResponseDto(Order order) {
        OrderDto.Response orderResponseDto = new OrderDto.Response();
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setMemberId(order.getMember().getMemberId());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        List<OrderCoffeeResponseDto> orderCoffees = order.getOrderCoffees().stream()
                .map(orderCoffee -> OrderCoffeeResponseDto
                        .builder()
                        .coffeeId(orderCoffee.getCoffee().getCoffeeId())
                        .korName(orderCoffee.getCoffee().getKorName())
                        .engName(orderCoffee.getCoffee().getEngName())
                        .price(orderCoffee.getCoffee().getPrice())
                        .quantity(orderCoffee.getQuantity())
                        .build())
                .collect(Collectors.toList());

        orderResponseDto.setOrderCoffees(orderCoffees);
        orderResponseDto.setCreatedAt(order.getCreatedAt());

        return orderResponseDto;
    }
}





