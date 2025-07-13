package com.cognizant.springlearn.springlearnrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnRestApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCountryException() throws Exception {
        ResultActions actions = mockMvc.perform(
                MockMvcRequestBuilders.get("/country/XX")
                        .accept(MediaType.APPLICATION_JSON));

        actions.andExpect(MockMvcResultMatchers.status().isBadRequest())
               .andExpect(MockMvcResultMatchers.status().reason("Country Not found"));
    }
}
