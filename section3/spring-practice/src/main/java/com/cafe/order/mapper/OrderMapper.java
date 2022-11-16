package com.cafe.order.mapper;

import com.cafe.order.dto.OrderCoffeeDto;
import com.cafe.order.dto.OrderCoffeeResponseDto;
import com.cafe.order.dto.OrderDto;
import com.cafe.order.entity.Order;
import com.cafe.order.entity.OrderCoffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "memberId", target = "member.memberId")
    Order orderPostDtoToOrder(OrderDto.Post orderPostDto);

    Order orderPatchDtoToOrder(OrderDto.Patch orderPatchDto);

    @Mapping(source = "coffeeId", target = "coffee.coffeeId")
    OrderCoffee orderCoffeeDtoToOrderCoffee(OrderCoffeeDto orderCoffeeDto);

    @Mapping(source = "coffee", target = ".")
    OrderCoffeeResponseDto orderCoffeeToOrderCoffeeResponseDto(OrderCoffee orderCoffee);

    @Mapping(source = "member.memberId", target = "memberId")
    OrderDto.Response orderToOrderResponseDto(Order order);
}