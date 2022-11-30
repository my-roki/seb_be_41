package com.codestates.operator.peeking;

import com.codestates.operator.data.Coffee;
import com.codestates.operator.data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * doOnNext() 기본 예제
 */
@Slf4j
public class DoOnNextExample01 {
    public static void main(String[] args) {
        Flux.fromIterable(SampleData.coffeeList)
                .doOnNext(coffee -> validateCoffee(coffee))
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()));
    }

    private static void validateCoffee(Coffee coffee) {
        if (coffee == null) {
            throw new RuntimeException("Not found.");
        }
    }
}