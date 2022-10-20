package com.codestates.section3week1.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") long price) {
        System.out.printf("# engName: %s%n", engName);
        System.out.printf("# korName: %s%n", korName);
        System.out.printf("# price: %s%n", price);

        // JSON 문자열 수작업을 Map 객체로 대체
        Map<String, Object> map = new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName);
        map.put("price", price);

        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

        // not implementation
        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.printf("# coffeeId: %d%n", coffeeId);

        // not implementation
        // 리턴 값을 ResponseEntity 객체로 변경
        return new ResponseEntity<>(HttpStatus.OK);

    }
}