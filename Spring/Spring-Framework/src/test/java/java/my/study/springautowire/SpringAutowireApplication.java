package java.my.study.springautowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAutowireApplication {

  @Autowired
  BookService bookService;
  public static void main(String[] args) {
    SpringApplication.run(SpringAutowireApplication.class, args);

  }


}
