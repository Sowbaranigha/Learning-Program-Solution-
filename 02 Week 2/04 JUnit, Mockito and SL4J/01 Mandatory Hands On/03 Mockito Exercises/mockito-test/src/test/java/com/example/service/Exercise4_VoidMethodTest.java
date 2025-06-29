package com.example.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise4_VoidMethodTest {

    @Test
    void shouldCallResetWithoutException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).reset();   // stub void

        new MyService(mockApi).resetSystem();
        verify(mockApi).reset();
    }
}
