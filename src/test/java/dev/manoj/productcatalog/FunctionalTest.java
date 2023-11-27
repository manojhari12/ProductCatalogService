package dev.manoj.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest //Allows us to test our APIs
public class FunctionalTest {

    @Autowired
    private MockMvc mockMvc; //Object used to send request

    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(200))
                .andExpect(content().string("{}"));
    }

}
