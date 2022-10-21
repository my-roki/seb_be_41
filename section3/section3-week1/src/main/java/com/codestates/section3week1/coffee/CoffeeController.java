package com.codestates.section3week1.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/coffees")
public class CoffeeController {
    // Mock data
    // coffeeId 는 고유한 값
    private long coffeeId = 0;
    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> coffee = new HashMap<>();
        coffeeId = coffeeId + 1L;
        coffee.put("coffeeId", coffeeId);
        coffee.put("korName", "바닐라 라떼");
        coffee.put("engName", "Vanilla Latte");
        coffee.put("price", 4500);

        coffees.put(coffeeId, coffee);
    }

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("engName") String engName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") long price) {
        System.out.printf("# engName: %s%n", engName);
        System.out.printf("# korName: %s%n", korName);
        System.out.printf("# price: %s%n", price);

        Map<String, Object> coffee = new HashMap<>();
        // coffeeId 는 고유한 값이므로 생성할때마다 1씩 증가합니다.
        coffeeId = coffeeId + 1L;
        coffee.put("coffeeId", coffeeId);
        coffee.put("korName", korName);
        coffee.put("engName", engName);
        coffee.put("price", price);

        coffees.put(coffeeId, coffee);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        return new ResponseEntity<>(coffees, HttpStatus.OK);

    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        // 조회하려는 커피가 있는지 확인합니다.
        if (!coffees.containsKey(coffeeId)) return new ResponseEntity(HttpStatus.NOT_FOUND);

        Map<String, Object> coffee = coffees.get(coffeeId);
        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                    @RequestParam(value = "korName", required = false) String korName,
                                    @RequestParam(value = "engName", required = false) String engName,
                                    @RequestParam(value = "price", required = false) Long price) {

        // 변경하려는 커피가 있는지 확인합니다.
        if (!coffees.containsKey(coffeeId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // coffees 에서 coffeeId 로 coffee 를 찾습니다.
        Map<String, Object> coffee = coffees.get(coffeeId);
        if (korName != null) coffee.replace("korName", korName);
        if (engName != null) coffee.replace("engName", engName);
        if (price != null) coffee.replace("price", price);
        coffees.replace(coffeeId, coffee);

        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }


    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // 삭제하려는 커피가 있는지 확인합니다.
        if (!coffees.containsKey(coffeeId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        coffees.remove(coffeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}