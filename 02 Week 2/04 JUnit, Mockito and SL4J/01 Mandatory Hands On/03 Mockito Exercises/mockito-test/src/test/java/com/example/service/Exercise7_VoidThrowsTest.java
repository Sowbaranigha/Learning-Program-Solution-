package com.example.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise7_VoidThrowsTest {

    @Test
    void shouldPropagateExceptionFromVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new IllegalStateException("boom")).when(mockApi).reset();

        MyService service = new MyService(mockApi);

        assertThrows(IllegalStateException.class, service::resetSystem);
        verify(mockApi).reset();
    }
}
