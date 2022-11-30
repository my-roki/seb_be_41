package com.codestates;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


/**
 * subscribeOn()과 publishOn()
 * <p>
 * - subscribeOn() : 데이터 소스에서 데이터를 emit하는 원본 Publisher의 실행 쓰레드를 지정
 * <br>
 * - publishOn() :  전달 받은 데이터를 가공 처리하는 Operator 앞에 추가해서 실행 쓰레드를 별도로 추가하는 역할
 */
@Slf4j
public class SchedulersExample3 {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))

                .publishOn(Schedulers.parallel())
                .filter(n -> n % 2 == 0)
                .doOnNext(data -> log.info("### filter doOnNext"))

                .publishOn(Schedulers.parallel())
                .map(n -> n * 2)
                .doOnNext(data -> log.info("# map doOnNext"))

                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(100L);
    }
}