package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise3_ArgumentMatcherTest {

    @Test
    void shouldPassCorrectId() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getUser(anyInt())).thenReturn("User‑X");

        MyService service = new MyService(mockApi);
        assertEquals("User‑X", service.getUserName(42));

        verify(mockApi).getUser(eq(42)); // verify argument value
    }
}
