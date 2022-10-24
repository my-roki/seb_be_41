package com.codestates.section3week1.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/coffees")
@Validated
public class CoffeeController {
    // Mock data
    // coffeeId 는 고유한 값
    private long coffeeId = 0;
    private final Map<Long, CoffeeDto> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        CoffeeDto coffee = new CoffeeDto();
        coffeeId = coffeeId + 1L;
        coffee.setCoffeeId(coffeeId);
        coffee.setEngName("Caffe Latte");
        coffee.setKorName("카페라떼");
        coffee.setPrice(4000);

        coffees.put(coffeeId, coffee);
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeeDto coffeeDto) {
        System.out.printf("# engName: %s%n", coffeeDto.getEngName());
        System.out.printf("# korName: %s%n", coffeeDto.getKorName());
        System.out.printf("# price: %s%n", coffeeDto.getPrice());

        coffeeId = coffeeId + 1;
        coffeeDto.setCoffeeId(coffeeId);

        coffees.put(coffeeId, coffeeDto);
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

        CoffeeDto coffee = (CoffeeDto) coffees.get(coffeeId);
        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeeDto coffeeDto) {

        // 변경하려는 커피가 있는지 확인합니다.
        if (!coffees.containsKey(coffeeId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        // coffees 에서 coffeeId 로 coffee 를 찾습니다.
        CoffeeDto coffee = coffees.get(coffeeId);
        if (coffee.getKorName() != null) coffee.setKorName(coffeeDto.getKorName());
        if (coffee.getEngName() != null) coffee.setEngName(coffeeDto.getEngName());
        if (coffee.getPrice() != null) coffee.setPrice(coffeeDto.getPrice());
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