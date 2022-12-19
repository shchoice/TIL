package my.study.event;

import my.study.springautowire.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationEventPublisherApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringApplicationEventPublisherApplication.class, args);
//    Thread[main,5,main]
//    Event Received, Data : 100
//    Thread[main,5,main]
//    Another 100
  }
}
