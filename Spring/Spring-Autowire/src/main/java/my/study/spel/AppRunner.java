package my.study.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Value("#{1 + 1}")
  int value;

  @Value("#{'hello ' + 'world'  }")
  String greeting;

  @Value("#{1 eq 1}")
  boolean trueOrFalse;

  @Value("hello")
  String hello;

  @Value("${my.name}")
  String name;

  @Value("#{${my.value} eq 100}")
  boolean isMyValue;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("===========================");
    System.out.println(value);
    System.out.println(greeting);
    System.out.println(trueOrFalse);
    System.out.println(hello);
    System.out.println(name);
    System.out.println(isMyValue);
  }
}
