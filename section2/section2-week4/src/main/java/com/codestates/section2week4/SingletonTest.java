package com.codestates.section2week4;

import com.codestates.section2week4.singleton.SingletonService;

public class SingletonTest {
    static SingletonService singletonService1 = SingletonService.getInstance();
    static SingletonService singletonService2 = SingletonService.getInstance();

    public static void main(String[] args) {
        System.out.printf("singletonService1 : %s%n", singletonService1);
        System.out.printf("singletonService2 : %s%n", singletonService2);
    }
}