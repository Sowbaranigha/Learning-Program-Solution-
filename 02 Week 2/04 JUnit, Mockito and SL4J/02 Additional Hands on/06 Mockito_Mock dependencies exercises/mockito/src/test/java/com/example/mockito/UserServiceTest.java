package com.example.mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById_returnsUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "Bob")));

        User user = userService.getUserById(1L);
        assertThat(user.getName()).isEqualTo("Bob");
    }
}
