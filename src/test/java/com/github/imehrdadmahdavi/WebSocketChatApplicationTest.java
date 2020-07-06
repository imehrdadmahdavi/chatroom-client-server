package com.github.imehrdadmahdavi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class WebSocketChatApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void userJoin() throws Exception {
        mockMvc.perform(get("/index?username=mehrdad"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("mehrdad")));
    }

    @Test
    public void chat() throws Exception {

        mockMvc.perform(get("/index?username=mehrdad"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("chat"));
    }

    @Test
    public void leave() throws Exception {
        chat();
        login();
    }
}