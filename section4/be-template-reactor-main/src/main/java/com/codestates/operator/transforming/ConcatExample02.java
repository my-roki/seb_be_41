package com.codestates.operator.transforming;

import com.codestates.operator.data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * concat() 기본 예제 2
 */
@Slf4j
public class ConcatExample02 {
    public static void main(String[] args) {
        Flux.concat(Flux.fromIterable(SampleData.salesOfCafeA),
                        Flux.fromIterable(SampleData.salesOfCafeB),
                        Flux.fromIterable(SampleData.salesOfCafeC))
                .reduce((a, b) -> a + b)
                .subscribe(data -> log.info("### Total sales: {}", data));
    }
}