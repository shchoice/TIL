package java.my.study.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
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

  @Value("#{'spring'}")
  String spring;

  @Value("#{sample.data}")
  int sampleData;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("===========================");
    System.out.println(value);        // 2
    System.out.println(greeting);     // hello world
    System.out.println(trueOrFalse);  // true
    System.out.println(hello);        // hello
    System.out.println(name);         // shchoi
    System.out.println(isMyValue);    // true
    System.out.println(spring);       // spring
    System.out.println(sampleData);   // 200

    ExpressionParser expressionParser = new SpelExpressionParser();
    Expression expression = expressionParser.parseExpression("2 + 100");
    Integer value = expression.getValue(Integer.class);
    System.out.println(value); // 102
  }
}
