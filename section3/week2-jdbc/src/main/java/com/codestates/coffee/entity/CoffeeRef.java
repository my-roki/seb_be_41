package com.codestates.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("ORDER_COFFEE")
public class CoffeeRef {
    private long coffeeId;   // N대N 관계에서는 AggregateReference 로 감쌀 필요가 없습니다.
    private int quantity;
}
