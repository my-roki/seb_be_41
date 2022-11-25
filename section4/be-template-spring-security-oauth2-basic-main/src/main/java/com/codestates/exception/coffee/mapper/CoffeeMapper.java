package com.codestates.exception.coffee.mapper;

import com.codestates.exception.coffee.dto.CoffeePatchDto;
import com.codestates.exception.coffee.dto.CoffeePostDto;
import com.codestates.exception.coffee.dto.CoffeeResponseDto;
import com.codestates.exception.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
