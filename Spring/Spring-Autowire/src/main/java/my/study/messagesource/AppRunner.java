package my.study.messagesource;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  MessageSource messageSource;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(messageSource.getClass()); // Spring Boot에서는 별다른 설정 없이 Bean 으로 사용할 수 있음
    System.out.println(messageSource.getMessage("greeting", new String[]{"스프링"}, Locale.getDefault()));
    System.out.println(messageSource.getMessage("greeting", new String[]{"스프링"}, Locale.KOREA));
    System.out.println(messageSource.getMessage("greeting", new String[]{"Spring"}, Locale.US));
    // 안녕하세요, 스프링
    // 안녕하세요, 스프링
    // Hello!, Spring
  }
}
