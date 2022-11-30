package com.codestates.operator.handling_error;

import com.codestates.operator.data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 에러 기본 예제
 */
@Slf4j
public class ErrorExample01 {
    public static void main(String[] args) {
        Mono.justOrEmpty(findVerifiedCoffee())
                .switchIfEmpty(Mono.error(new RuntimeException("Not found coffee")))
                .subscribe(
                        data -> log.info("{} : {}", data.getKorName(), data.getPrice()),
                        error -> log.error("### onError: {}", error.getMessage()));
    }

    private static Coffee findVerifiedCoffee() {
        return null;
    }
}