package com.codestates;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class HelloReactorExample {
    public static void main(String[] args) throws InterruptedException {
        Flux  // Reactor Sequence가 여러건의 데이터를 처리합니다.
                .just("Hello", "Reactor!")  // Publisher
                .map(message -> message.toUpperCase())  // Operator
                .publishOn(Schedulers.parallel())  // Reactor Sequence에서 쓰레드 관리자 역할을 하는 Scheduler를 지정
                .subscribe(System.out::println,  // Publisher가 emit한 데이터를 전달받아 처리
                        error -> System.out.println(error.getMessage()),  // 에러가 발생할경우 에러를 전달받아서 처리
                        () -> System.out.println("### onComplete"));  // Reactor Sequence가 종료된 후 후처리

        // Reactor Sequence에 Scheduler를 지정하면 main 쓰레드 이외에 별도의 데몬 쓰레드가 하나 더 생깁니다.
        // Reactor에서 Scheduler로 지정한 데몬 쓰레드는 main 쓰레드가 종료되면 동시에 종료됩니다.
        // 따라서 main 쓰레드를 Thread.sleep(100L)을 통해 0.1초 정도 동작을 지연시켜 데몬 쓰레드를 실행시킵니다.
        Thread.sleep(100L);
    }
}