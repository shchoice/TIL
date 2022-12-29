package java.my.study.databinding;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  public void getTest() throws Exception {
    mockMvc.perform(get("/event/1"))
        .andExpect(status().isOk())
        .andExpect(content().string("1"));
  }
  // Event{id=1, title='null'}
}
