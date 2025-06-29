// src/test/java/com/example/CalculatorFixtureTest.java
package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorFixtureTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // Arrange: Create new instance before each test
        calc = new Calculator();
        System.out.println("setUp() called");
    }

    @After
    public void tearDown() {
        // Clean up after each test
        calc = null;
        System.out.println("tearDown() called");
    }

    @Test
    public void testAddShouldUpdateLastResult() {
        // Act
        int result = calc.add(4, 6);

        // Assert
        assertEquals(10, result);
        assertEquals(10, calc.getLastResult());
    }

    @Test
    public void testClearShouldResetLastResult() {
        // Act
        calc.add(5, 5);
        calc.clear();

        // Assert
        assertEquals(0, calc.getLastResult());
    }
}
