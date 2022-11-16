package com.cafe.order.controller;

import com.cafe.advice.coffee.service.CoffeeService;
import com.cafe.response.MultiResponseDto;
import com.cafe.response.SingleResponseDto;
import com.cafe.order.dto.OrderDto;
import com.cafe.order.entity.Order;
import com.cafe.order.mapper.OrderMapper;
import com.cafe.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/orders")
@Validated
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;

    public OrderController(OrderService orderService, OrderMapper mapper, CoffeeService coffeeService) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postOrder(@Valid @RequestBody OrderDto.Post orderPostDto) {
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));
        OrderDto.Response response = mapper.orderToOrderResponseDto(order);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getOrders(@RequestParam @Positive int page,
                                    @RequestParam @Positive int size) {
        Page<Order> orderPage = orderService.findOrders(page - 1, size);
        List<Order> orders = orderPage.getContent();
        List<OrderDto.Response> response = orders.stream()
                .map(mapper::orderToOrderResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new MultiResponseDto<>(response, orderPage), HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
        Order order = orderService.findOrder(orderId);
        OrderDto.Response response = mapper.orderToOrderResponseDto(order);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                     @RequestBody OrderDto.Patch orderPatchDto) {
        orderPatchDto.setOrderId(orderId);
        Order order = orderService.updateOrder(mapper.orderPatchDtoToOrder(orderPatchDto));
        OrderDto.Response response = mapper.orderToOrderResponseDto(order);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}