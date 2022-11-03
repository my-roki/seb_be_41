package com.codestates.order.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.service.MemberService;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private MemberService memberService;

    public OrderService(OrderRepository orderRepository, MemberService memberService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
    }

    public Order createOrder(Order order) {
        System.out.println(order.getMember());
        memberService.findVerifiedMember(order.getMember().getMemberId());

        // TODO: 커피가 존재해야하는지 확인해야 함.

        return orderRepository.save(order);
    }

    // 주문 상태 처리를 위한 updateOrder() 메서드 추가
    public Order updateOrder(Order order) {
        Order verifiedOrder = findVerifiedOrder(order.getOrderId());

        Optional.ofNullable(order.getOrderStatus()).ifPresent(verifiedOrder::setOrderStatus);
        verifiedOrder.setModifiedAt(LocalDateTime.now());

        return orderRepository.save(verifiedOrder);
    }

    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }

    public Page<Order> findOrders(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size,
                Sort.by("orderId").descending()));
    }

    public void cancelOrder(long orderId) {
        Order verifiedOrder = findVerifiedOrder(orderId);
        int step = verifiedOrder.getOrderStatus().getStepNumber();

        if (step >= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        verifiedOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        verifiedOrder.setModifiedAt(LocalDateTime.now());
        orderRepository.save(verifiedOrder);
    }

    private Order findVerifiedOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order order = optionalOrder.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));

        return order;
    }
}
