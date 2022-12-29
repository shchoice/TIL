package my.study.event;

import my.study.springautowire.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringApplicationEventPublisherApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringApplicationEventPublisherApplication.class, args);
//    Thread[main,5,main]
//    Another 100
//    Thread[task-1,5,main]
//    Event Received, Data : 100
  }
}
