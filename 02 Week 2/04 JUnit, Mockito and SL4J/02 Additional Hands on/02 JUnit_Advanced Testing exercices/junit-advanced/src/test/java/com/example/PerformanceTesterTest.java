package com.example;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceTesterTest {
    PerformanceTester pt = new PerformanceTester();

    @Test
    void completesUnderHalfSecond() {
        assertTimeout(Duration.ofMillis(500), pt::performTask);
    }
}
