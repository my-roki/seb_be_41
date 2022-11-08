package com.codestates.basic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BeforeAllTest {
    private static Map<String, String> map;

    // @BeforeAll 어노테이션은 테스트 케이스가 시작되기 전 딱 한번만 초기화 작업을 실행합니다
    // @BeforeAll 애너테이션을 추가한 메서드는 정적 메서드(static method)여야 합니다.
    @BeforeAll
    public static void initAll() {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "Cardano");
        map.put("DOT", "Polkadot");
        map.put("DOGE", "Dogecoin");
        map.put("XRP", "Ripple");

        System.out.println("initialize Crypto Currency map");
    }

    @DisplayName("@BeforeAll Test case 1")
    @Test
    public void beforeAllTest1() {
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    @DisplayName("@BeforeAll Test case 2")
    @Test
    public void beforeAllTest2() {
        assertDoesNotThrow(() -> getCryptoCurrency("ADA"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}