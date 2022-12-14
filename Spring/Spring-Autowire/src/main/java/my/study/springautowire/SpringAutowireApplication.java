package my.study.springautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class SpringAutowireApplication {

  @Autowired
  BookService bookService;
  public static void main(String[] args) {
    SpringApplication.run(SpringAutowireApplication.class, args);

  }


}
