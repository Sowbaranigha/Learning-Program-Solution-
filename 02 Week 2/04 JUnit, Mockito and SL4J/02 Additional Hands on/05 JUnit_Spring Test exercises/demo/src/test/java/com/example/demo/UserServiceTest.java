package com.example.demo;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock  UserRepository repo;
    @InjectMocks  UserService service;

    @Test
    void getUserById_existing_returnsUser() {
        User alice = new User(1L, "Alice");
        when(repo.findById(1L)).thenReturn(Optional.of(alice));
        assertThat(service.getUserById(1L)).isEqualTo(alice);
    }
}
