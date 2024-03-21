package com.webapp.springboot.backendtutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WelcomeControllerTest {

    private final String name = "Sunny";
    @Autowired
    private MockMvc mvc;

    @Test
    public void getWelcomeDefaultRequestParam() throws Exception {
        testGreetingController("/greeting", "World");
    }

    @Test
    public void getWelcomePersonPathVariable() throws Exception {
        testGreetingController("/greeting/%s", name);
    }

    @Test
    public void getWelcomePersonRequestParam() throws Exception {
        testGreetingController("/greeting?name=%s", name);
    }

    public void testGreetingController(String uri, String name) throws Exception {
        String greeting = "Hello %s! Welcome to the Backend Tutorial :)";
        mvc.perform(MockMvcRequestBuilders.get(String.format(uri, name)).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.format(greeting, name)));
    }
}
