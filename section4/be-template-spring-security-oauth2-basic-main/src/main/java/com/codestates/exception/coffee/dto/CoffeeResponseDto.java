package com.codestates.exception.coffee.dto;

import com.codestates.exception.coffee.entity.Coffee;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CoffeeResponseDto {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private Coffee.CoffeeStatus coffeeStatus;

    public String getCoffeeStatus() {
        return coffeeStatus.getStatus();
    }
}
