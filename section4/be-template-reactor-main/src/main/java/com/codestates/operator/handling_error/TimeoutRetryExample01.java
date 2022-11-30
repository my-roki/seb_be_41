package com.codestates.operator.handling_error;

import com.codestates.operator.data.Coffee;
import com.codestates.operator.data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Collectors;

/**
 * timeout(), retry() 기본 예제
 */
@Slf4j
public class TimeoutRetryExample01 {
    public static void main(String[] args) throws InterruptedException {
        getCoffees()
                .collect(Collectors.toSet())
                .subscribe(set -> set.stream()
                        .forEach(data -> log.info("{} : {}", data.getKorName(), data.getPrice())));
        Thread.sleep(12000);
    }

    private static Flux<Coffee> getCoffees() {
        final int[] count = {0};
        return Flux.fromIterable(SampleData.coffeeList)
                .delayElements(Duration.ofMillis(500L))
                .map(coffee -> {
                    try {
                        count[0]++;
                        if (count[0] == 3) {
                            Thread.sleep(2000L);
                        }
                    } catch (InterruptedException e) {
                    }

                    return coffee;
                })
                .timeout(Duration.ofSeconds(2))
                .retry(1)
                .doOnNext(coffee -> log.info("### getCoffees > doOnNext: {}, {}",
                        coffee.getKorName(), coffee.getPrice()));
    }
}