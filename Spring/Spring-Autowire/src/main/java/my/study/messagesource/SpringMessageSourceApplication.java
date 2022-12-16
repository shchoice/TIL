package my.study.messagesource;

import my.study.springautowire.SpringAutowireApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class SpringMessageSourceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringMessageSourceApplication.class, args);
  }
}
