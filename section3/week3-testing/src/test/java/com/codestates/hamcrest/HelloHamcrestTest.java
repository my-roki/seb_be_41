package com.codestates.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HelloHamcrestTest {
    @DisplayName("Hello Junit Test using hamcrest")
    @Test
    public void assertionTest1() {
        String expected = "Hello, JUnit";
        String actual = "Hello, World";

        assertThat(actual, is(equalTo(expected)));  // (1)
    }
}