package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest                           // lightweight, only JPA components
class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Test
    void findByName_returnsMatches() {
        // WHEN – persist two users
        repo.save(new User(null, "Eve"));
        repo.save(new User(null, "Adam"));

        // THEN – query by name
        List<User> list = repo.findByName("Eve");
        assertThat(list)
            .hasSize(1)
            .extracting(User::getName)
            .containsExactly("Eve");
    }
}
