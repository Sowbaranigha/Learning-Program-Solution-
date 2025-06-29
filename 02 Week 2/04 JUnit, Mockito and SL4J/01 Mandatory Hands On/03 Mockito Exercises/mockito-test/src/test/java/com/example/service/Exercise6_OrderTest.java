package com.example.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class Exercise6_OrderTest {

    @Test
    void shouldCallGetDataBeforeReset() {
        ExternalApi mockApi = mock(ExternalApi.class);
        new MyService(mockApi).doTwoCallsInOrder();

        InOrder order = inOrder(mockApi);
        order.verify(mockApi).getData();
        order.verify(mockApi).reset();
    }
}
