package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {
    @Test
    void throwsIllegalState() {
        ExceptionThrower et = new ExceptionThrower();
        assertThrows(IllegalStateException.class, et::throwException);
    }
}
