package com.example.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class Exercise2_VerifyCallTest {

    @Test
    void shouldCallGetDataExactlyOnce() {
        ExternalApi mockApi = mock(ExternalApi.class);
        new MyService(mockApi).fetchData();

        verify(mockApi).getData();   // passes if called once
    }
}
