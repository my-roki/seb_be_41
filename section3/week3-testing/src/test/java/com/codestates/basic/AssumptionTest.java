package com.codestates.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {
    @DisplayName("Assumption Test")
    @Test
    public void assumptionTest(){
        // assumeTrue() 메서드는 파라미터로 입력된 값이 true이면 나머지 아래 로직들을 실행합니다.
        System.out.println(System.getProperty("os.name"));
        // assumeTrue(System.getProperty("os.name").startsWith("Windows"));
        // assumeTrue(System.getProperty("os.name").startsWith("Linux"));
        assumeTrue(System.getProperty("os.name").startsWith("Mac"));

        System.out.println("execute?");
        assertTrue(processOnlyWindowsTask());
    }

    private boolean processOnlyWindowsTask() {
        return true;
    }
}