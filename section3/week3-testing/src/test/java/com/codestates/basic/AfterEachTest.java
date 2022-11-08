package com.codestates.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AfterEachTest {
    private static final Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
    }

    // @AfterEach 을 추가한 메서드는 각 테스트가 실행되고 나서 이후에 실행됩니다.
    @AfterEach
    public void init() {
        if (!map.containsKey("ETH")) map.put("ETH", "Ethereum");
        System.out.println("Post-processing before each test case");
    }

    @DisplayName("@BeforeEach Test case 1")
    @Test
    public void beforeEachTest1() {
        // 첫번쨰 테스트에선 fail 되는 결과값을 입력
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("ETH"));
    }

    @DisplayName("@BeforeEach Test case 2")
    @Test
    public void beforeEachTest2() {
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("ETH"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}