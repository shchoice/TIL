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
    // VM options에 -Dapp.name="Spring5" 적음
    System.out.println(environment.getProperty("app.name")); // Spring5

  }
}
