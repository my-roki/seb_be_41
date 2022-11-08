package com.codestates.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AfterAllTest {
    private static Map<String, String> map;

    // 처음 map 요소 개수는 2개
    static {
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
    }

    // @AfterAll 어노테이션은 테스트 케이스가 종료 후 딱 한 번 실행됩니다.
    // @AfterAll 애너테이션을 추가한 메서드는 정적 메서드(static method)여야 합니다.
    @AfterAll
    public static void initAll() {
        map.put("ETH", "Ethereum");
        System.out.println("Result of Crypto Currency map");
        System.out.println(map);  // 마지막으로 ETH 를 추가해서 다시 2개가 됨
    }

    @DisplayName("@AfterAll Test case 1")
    @Test
    public void AfterAllTest1() {
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("ETH"));
        map.remove("ETH");  // map에서 요소 1개를 지움
    }

    @DisplayName("@AfterAll Test case 2")
    @Test
    public void AfterAllTest2() {
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("ETH"));  // 지운 요소를 가져오려하니 테스트 통과 x
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}