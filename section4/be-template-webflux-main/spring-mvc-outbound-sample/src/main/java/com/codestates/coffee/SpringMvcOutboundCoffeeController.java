package com.codestates.coffee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v11/coffees")
public class SpringMvcOutboundCoffeeController {
    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) throws InterruptedException {
        CoffeeResponseDto responseDto = new CoffeeResponseDto(coffeeId, "카페라테", "Cafe Latte", 4000);

        // 의도적으로 5초의 delay
        Thread.sleep(5000L);
        return ResponseEntity.ok(responseDto);
    }
}