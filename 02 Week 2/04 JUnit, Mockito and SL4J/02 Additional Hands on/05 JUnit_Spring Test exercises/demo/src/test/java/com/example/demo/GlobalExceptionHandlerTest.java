package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// NEW import ‑‑ replaces org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(UserController.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean          // ← updated annotation
    private UserService userService;

    @Test
    void noSuchElement_mapsTo404() throws Exception {
        when(userService.getUserById(123L)).thenThrow(new NoSuchElementException());

        mvc.perform(get("/users/123"))
           .andExpect(status().isNotFound())
           .andExpect(content().string("User not found"));
    }
}
