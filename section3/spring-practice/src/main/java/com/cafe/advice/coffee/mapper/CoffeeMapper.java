package com.cafe.advice.coffee.mapper;

import com.cafe.advice.coffee.dto.CoffeeDto;
import com.cafe.advice.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeeDto.Post coffeePostDto);

    Coffee coffeePatchDtoToCoffee(CoffeeDto.Patch coffeePatchDto);

    CoffeeDto.Response coffeeToCoffeeResponseDto(Coffee coffee);

    List<CoffeeDto.Response> coffeesToListMemberResponseDto(List<Coffee> coffeeList);

}