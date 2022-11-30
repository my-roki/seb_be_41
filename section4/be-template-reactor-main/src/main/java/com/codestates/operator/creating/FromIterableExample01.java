package com.codestates.operator.creating;

import com.codestates.operator.data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * fromIterable() 기본 예제
 */
@Slf4j
public class FromIterableExample01 {
    public static void main(String[] args) {
        Flux.fromIterable(SampleData.coffeeList)
                .subscribe(coffee -> log.info("{} : {}", coffee.getKorName(), coffee.getPrice()));
    }
}