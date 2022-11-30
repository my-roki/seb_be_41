package com.codestates.operator.transforming;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * zip() 기본 예제
 *
 * 각각의 Sequence에서 emit되는 데이터 중에서 같은 차례(index)의 데이터들이 결합됩니다.
 * 각 Sequence에서 emit되는 데이터의 시점이 다르면 결합되어야 하는 모든 index가 emit이 될 때까지 기다렸다가 결합합니다.
 * Sequence는 결합할 대상이 없으면 남은 데이터는 폐기 됩니다.
 */
@Slf4j
public class ZipExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux<Long> src1 = Flux.interval(Duration.ofMillis(200L)).take(4);
        Flux<Long> src2 = Flux.interval(Duration.ofMillis(400L)).take(6);

        Flux.zip(src1, src2, (data1, data2) -> data1 + data2)
                .subscribe(data -> log.info("### onNext: {}", data));

        Thread.sleep(3000L);
    }
}