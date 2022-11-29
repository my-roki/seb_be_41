package com.codestates;

import reactor.core.publisher.Mono;

// 리액티브 프로그래밍 기본 구조
public class HelloReactiveExample {
    public static void main(String[] args) {
        // Publisher의 역할
        Mono<String> mono = Mono.just("Hello, Reactive!");

        // Subscriber의 역할
        mono.subscribe(message -> System.out.println(message));


        // 위 Publisher와 Subscriber를 메서드 체인 형식으로 표현할 수 있습니다.
        Mono.just("Hello, Reactive!")
                .subscribe(System.out::println);  // Method Reference
    }
}