package me.study.springmvc.simple;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SimpleControllerTest {

  @Autowired
  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  private MockMvc mockMvc;

  @Test
  public void hello() throws Exception {
    this.mockMvc.perform(get("/hello/Spring"))
        .andDo(print())
        .andExpect(content().string("hello Spring"));
  }
}