package com.codestates.operator.creating;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

/**
 * fromStream() 기본 예제
 */
public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux.fromStream(Stream.of(200, 300, 400, 500, 600))  //  fromStream()의 입력으로 Stream을 전달
                .reduce((a, b) -> a + b)
                .subscribe(System.out::println);
    }
}