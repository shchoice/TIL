package my.study.bean.scope;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ApplicationContext applicationContext;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Environment environment = applicationContext.getEnvironment();
    // 다만 vm option 이 app.properties 보다 우선순위가 높음
    System.out.println(environment.getProperty("app.name")); // Spring
  }
}
