package com.codestates.coffee.mapper;

import com.codestates.coffee.dto.CoffeeDto;
import com.codestates.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeeDto.Post coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeeDto.Patch coffeePatchDto);
    CoffeeDto.Response coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeDto.Response> coffeesToCoffeeResponses(List<Coffee> coffees);
}
