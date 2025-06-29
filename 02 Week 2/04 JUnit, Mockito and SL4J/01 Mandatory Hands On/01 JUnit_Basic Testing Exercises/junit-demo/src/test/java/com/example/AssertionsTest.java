// src/test/java/com/example/AssertionsTest.java
package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testBasicAssertions() {
        assertEquals(5, 2 + 3);       // equals
        assertTrue(5 > 3);            // true
        assertFalse(5 < 3);           // false
        assertNull(null);             // null
        assertNotNull(new Object());  // not‑null
    }
}
