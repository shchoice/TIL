package my.study.springcorebasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest() {
    // ApplicationContext로 하면 에러 나옴
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    NetworkClient client = context.getBean(NetworkClient.class);
    context.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요
  }

  @Configuration
  static class LifeCycleConfig {
    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("http://hello-spring.dev");

      return networkClient;
    }
  }
}
