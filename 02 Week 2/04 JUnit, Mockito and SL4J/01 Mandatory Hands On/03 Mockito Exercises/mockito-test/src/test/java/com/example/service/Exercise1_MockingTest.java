package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise1_MockingTest {

    @Test
    void shouldReturnStubbedValue() {
        // 1. mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. stub
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. inject & call
        MyService service = new MyService(mockApi);
        assertEquals("Mock Data", service.fetchData());
    }
}
