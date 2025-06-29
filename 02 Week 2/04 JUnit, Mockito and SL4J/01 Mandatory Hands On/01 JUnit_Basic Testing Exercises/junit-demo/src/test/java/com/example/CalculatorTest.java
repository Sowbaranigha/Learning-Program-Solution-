// src/test/java/com/example/CalculatorTest.java
package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void add_shouldReturnSum() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }
}
