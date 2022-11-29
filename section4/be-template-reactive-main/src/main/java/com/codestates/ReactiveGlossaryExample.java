package com.codestates;

import reactor.core.publisher.Flux;

import java.util.List;

public class ReactiveGlossaryExample {
    public static void main(String[] args) {
        Flux.fromIterable(List.of(1, 4, 2, 8, 9, 13, 12, 14, 3))
                .filter(n -> n > 4 && n % 2 == 0)
                .reduce((n1, n2) -> n1 + n2)
                .subscribe(System.out::println);
    }
}