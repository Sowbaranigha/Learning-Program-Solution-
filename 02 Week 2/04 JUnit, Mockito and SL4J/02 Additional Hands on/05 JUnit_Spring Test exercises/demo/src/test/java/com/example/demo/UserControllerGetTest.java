package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// NEW import (replaces org.springframework.boot.test.mock.mockito.MockBean)
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(UserController.class)
class UserControllerGetTest {

    @Autowired
    private MockMvc mvc;

    // use @MockitoBean instead of @MockBean
    @MockitoBean
    private UserService userService;

    @Test
    void getUser_returnsJson() throws Exception {
        // GIVEN
        when(userService.getUserById(1L)).thenReturn(new User(1L, "Alice"));

        // WHEN + THEN
        mvc.perform(get("/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Alice"));
    }
}
