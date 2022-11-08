package com.codestates.basic;

import com.codestates.CryptoCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BeforeEachTest {
    private Map<String, String> map;

    // @BeforeEach 을 추가한 메서드는 각 테스트가 실행될 때마다 직전에 실행됩니다.
    @BeforeEach
    public void init() {
        System.out.println("Pre-processing before each test case");
        map = new HashMap<>();
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "Cardano");
        map.put("DOT", "Polkadot");
        map.put("DOGE", "Dogecoin");
    }

    @DisplayName("@BeforeEach Test case 1")
    @Test
    public void beforeEachTest1() {
        // 첫번쨰 테스트에선 pass 되는 결과값을 입력
        map.put("XRP", "Ripple");
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }


    @DisplayName("@BeforeEach Test case 2")
    @Test
    public void beforeEachTest2() {
        // 두번째 테스트에선 없이 그냥 진행
        System.out.println(map);
        assertDoesNotThrow(() -> getCryptoCurrency("XRP"));
    }

    private String getCryptoCurrency(String unit) {
        return map.get(unit).toUpperCase();
    }
}