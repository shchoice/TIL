package java.my.study.validation;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  Validator validator;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(validator.getClass());

    Event event = new Event();
    event.setLimit(-1);
    event.setEmail("Not Email  Type");

    Errors errors = new BeanPropertyBindingResult(event, "event");

    validator.validate(event, errors);

    System.out.println(errors.hasErrors()); // true

    errors.getAllErrors().forEach(e -> {
      System.out.println("===== Error Code ====");
      Arrays.stream(e.getCodes()).forEach(System.out::println);
      System.out.println(e.getDefaultMessage());
    });
//    ===== Error Code ====
//    NotEmpty.event.title
//    NotEmpty.title
//    NotEmpty.java.lang.String
//        NotEmpty
//    비어 있을 수 없습니다
//    ===== Error Code ====
//    Email.event.email
//    Email.email
//    Email.java.lang.String
//        Email
//    올바른 형식의 이메일 주소여야 합니다
//        ===== Error Code ====
//    Min.event.limit
//    Min.limit
//    Min.java.lang.Integer
//        Min
//    0 이상이어야 합니다

  }
}
