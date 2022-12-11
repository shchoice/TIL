package my.study.springapplicationcontext;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringApplicationContextApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringApplicationContextApplication.class, args);
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    String[] beanDefinitionNames = context.getBeanDefinitionNames();
    System.out.println(Arrays.toString(beanDefinitionNames));
    BookService bookService = (BookService) context.getBean("bookService");
    System.out.println(bookService.bookRepository != null);
  }

}
