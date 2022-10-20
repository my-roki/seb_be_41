package com.codestates.section3week1.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @PostMapping
    public String postOrder(@RequestParam("memberId") long memberId,
                            @RequestParam("coffeeId") long coffeeId) {
        System.out.printf("# memberId: %d%n", memberId);
        System.out.printf("# coffeeId: %d%n", coffeeId);

        String response = "{\"" +
                "memberId\":\"" + memberId + "\"," +
                "\"coffeeId\":\"" + coffeeId + "\"}";
        return response;
    }

    @GetMapping
    public String getOrders() {
        System.out.println("# get Orders");

        // not implementation
        return null;
    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") long orderId) {
        System.out.printf("# orderId: %d%n", orderId);

        // not implementation
        return null;
    }
}