package com.codestates.operator.transforming;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import static java.lang.Thread.sleep;

/**
 * flatMap() 기본 예제
 * flatMap() Operator에서 추가 쓰레드를 할당할 경우, 작업의 처리 순서를 보장하지 않습니다.
 */
@Slf4j
public class FlatMapExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(2, 8)
                .flatMap(dan ->
                        Flux.range(1, 9)
                                .publishOn(Schedulers.parallel())
                                .map(num -> dan + " x " + num + " = " + dan * num))
                .subscribe(log::info);

        Thread.sleep(1000L);
    }
}