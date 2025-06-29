package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceParameterizedTest {

    CalculatorService service = new CalculatorService();

    @ParameterizedTest(name = "{0}+{1}={2}")
    @CsvSource({
        "1, 2, 3",
        "5, 7, 12",
        "-3, 3, 0"
    })
    void add_variousPairs(int a, int b, int expected) {
        assertThat(service.add(a, b)).isEqualTo(expected);
    }
}
