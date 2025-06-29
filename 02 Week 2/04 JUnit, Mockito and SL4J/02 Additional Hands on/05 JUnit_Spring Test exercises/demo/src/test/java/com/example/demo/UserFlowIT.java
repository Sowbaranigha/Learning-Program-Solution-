package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional                    // keep INSERT + SELECT in same session
class UserFlowIT {

    @Autowired
    private UserService userService;

    @Test
    void createAndReadUser() {
        // GIVEN  – save a new user
        User saved = userService.saveUser(new User(null, "Bob"));

        // WHEN   – fetch it back
        User fetched = userService.getUserById(saved.getId());

        // THEN
        assertThat(fetched.getName()).isEqualTo("Bob");
    }
}
