package com.codestates.section3week1.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId) {
        System.out.printf("# memberId: %d%n", memberId);
        System.out.printf("# coffeeId: %d%n", coffeeId);

        // JSON 문자열 수작업을 Map 객체로 대체
        Map<String, Long> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeId", coffeeId);

        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        System.out.println("# get Orders");

        // not implementation
        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        System.out.printf("# orderId: %d%n", orderId);

        // not implementation
        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(HttpStatus.OK);
    }
}