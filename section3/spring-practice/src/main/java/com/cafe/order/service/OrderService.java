package com.cafe.order.service;

import com.cafe.coffee.service.CoffeeService;
import com.cafe.exception.BusinessLogicException;
import com.cafe.exception.ExceptionCode;
import com.cafe.member.entity.Member;
import com.cafe.member.service.MemberService;
import com.cafe.order.entity.Order;
import com.cafe.order.entity.OrderCoffee;
import com.cafe.order.repository.OrderRepository;
import com.cafe.stamp.Stamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private MemberService memberService;
    private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository, MemberService memberService, CoffeeService coffeeService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }

    public Order createOrder(Order order) {
        // 주문한 member가 존재하는 회원인지 확인
        Member member = memberService.isMemberExist(order.getMember().getMemberId());

        // 주문한 coffee가 존재하는 커피인지 확인
        order.getOrderCoffees().stream()
                .forEach(orderCoffee -> {
                    coffeeService.isCoffeeExist(orderCoffee.getCoffee().getCoffeeId());
                    orderCoffee.setOrder(order);
                });

        // Update stamp
        Stamp stamp = member.getStamp();
        int stampCount = order.getOrderCoffees().stream()
                .map(OrderCoffee::getQuantity)
                .mapToInt(quantity -> quantity)
                .sum();

        stamp.setStampCount(stamp.getStampCount() + stampCount);
        member.setStamp(stamp);

        return orderRepository.save(order);
    }

    public Page<Order> findOrders(int page, int size) {

        return orderRepository.findAll(PageRequest.of(page, size,
                Sort.by("orderId")));
    }

    public Order findOrder(Long orderId) {
        return isOrderExist(orderId);
    }

    public Order updateOrder(Order order) {
        Order orderExist = isOrderExist(order.getOrderId());
        Optional.ofNullable(order.getOrderStatus()).ifPresent(orderExist::setOrderStatus);

        return orderRepository.save(orderExist);
    }

    public void cancelOrder(Long orderId) {
        Order orderExist = isOrderExist(orderId);

        if (orderExist.getOrderStatus().getStepNumber() >= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }
        orderExist.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(orderExist);
    }

    private Order isOrderExist(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        return optionalOrder.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
    }
}