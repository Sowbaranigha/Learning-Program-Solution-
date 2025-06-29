package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    private final CalculatorService service = new CalculatorService();

    @Test
    void add_returnsSum() {
        assertThat(service.add(2, 3)).isEqualTo(5);
    }
}
