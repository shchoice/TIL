package springapplicationcontext;

import java.util.Arrays;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringApplicationContextApplication {

  public static void main(String[] args) {
//    SpringApplication.run(SpringApplicationContextApplication.class, args);
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    String[] beanDefinitionNames = context.getBeanDefinitionNames();
    System.out.println(Arrays.toString(beanDefinitionNames));
    // [org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalCommonAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, applicationConfig, bookRepository, bookService]
    BookService bookService = (BookService) context.getBean("bookService");
    System.out.println(bookService.bookRepository != null);
    // true
  }

}
