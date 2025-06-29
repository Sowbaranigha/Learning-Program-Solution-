package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// ← new import
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(UserController.class)
class UserControllerPostTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    // ← use @MockitoBean instead of @MockBean
    @MockitoBean
    private UserService userService;

    @Test
    void createUser_returnsSavedUser() throws Exception {
        User saved = new User(10L, "Carol");
        when(userService.saveUser(any(User.class))).thenReturn(saved);

        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new User(null, "Carol"))))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id").value(10))
           .andExpect(jsonPath("$.name").value("Carol"));
    }
}
