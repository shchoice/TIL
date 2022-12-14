package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ApplicationContext applicationContext;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Proto");
    System.out.println(applicationContext.getBean(Proto.class));
    System.out.println(applicationContext.getBean(Proto.class));
    System.out.println(applicationContext.getBean(Proto.class));

    System.out.println("Singleton");
    System.out.println(applicationContext.getBean(Single.class));
    System.out.println(applicationContext.getBean(Single.class));
    System.out.println(applicationContext.getBean(Single.class));
  }
}
