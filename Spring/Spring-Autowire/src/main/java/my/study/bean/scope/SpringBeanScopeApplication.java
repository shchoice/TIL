package my.study.bean.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SpringBeanScopeApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBeanScopeApplication.class, args);

  }


}
