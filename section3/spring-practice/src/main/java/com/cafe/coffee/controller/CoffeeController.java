package com.cafe.coffee.controller;

import com.cafe.coffee.entity.Coffee;
import com.cafe.coffee.service.CoffeeService;
import com.cafe.coffee.dto.CoffeeDto;
import com.cafe.coffee.mapper.CoffeeMapper;
import com.cafe.response.MultiResponseDto;
import com.cafe.response.SingleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/coffees")
@Validated
public class CoffeeController {
    CoffeeService coffeeService;
    CoffeeMapper mapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper mapper) {
        this.coffeeService = coffeeService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeeDto.Post coffeePostDto) {
        Coffee coffee = coffeeService.createCoffee(mapper.coffeePostDtoToCoffee(coffeePostDto));
        CoffeeDto.Response response = mapper.coffeeToCoffeeResponseDto(coffee);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getCoffees(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {
        Page<Coffee> coffeePage = coffeeService.findCoffees(page - 1, size);
        List<Coffee> coffees = coffeePage.getContent();
        List<CoffeeDto.Response> response = mapper.coffeesToListMemberResponseDto(coffees);

        return new ResponseEntity<>(new MultiResponseDto<>(response, coffeePage), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        Coffee coffee = coffeeService.findCoffee(coffeeId);
        CoffeeDto.Response response = mapper.coffeeToCoffeeResponseDto(coffee);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeeDto.Patch coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);
        Coffee coffee = coffeeService.updateCoffee(mapper.coffeePatchDtoToCoffee(coffeePatchDto));
        CoffeeDto.Response response = mapper.coffeeToCoffeeResponseDto(coffee);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") @Positive long coffeeId) {
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}