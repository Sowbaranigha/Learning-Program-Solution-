package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise5_MultipleReturnsTest {

    @Test
    void shouldReturnDifferentValuesOnConsecutiveCalls() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("A").thenReturn("B");

        String combined = new MyService(mockApi).fetchTwice();
        assertEquals("A | B", combined);
    }
}
