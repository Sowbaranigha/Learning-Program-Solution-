package com.example.demo;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionTest {

    @Mock  UserRepository repo;
    @InjectMocks  UserService service;

    @Test
    void missingUser_throwsNoSuchElement() {
        when(repo.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.getUserById(99L))
            .isInstanceOf(java.util.NoSuchElementException.class);
    }
}
