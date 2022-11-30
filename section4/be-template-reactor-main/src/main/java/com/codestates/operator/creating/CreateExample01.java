package com.codestates.operator.creating;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CreateExample01 {
    private static List<Integer> source = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);

    public static void main(String[] args) {
        Flux.create((FluxSink<Integer> sink) -> {
            sink.onRequest(n -> {
                for (Integer integer : source) {
                    sink.next(integer);
                }
                sink.complete();
            });

            sink.onDispose(() -> log.info("# clean up"));
        }).subscribe(data -> log.info("# onNext: {}", data));
    }
}