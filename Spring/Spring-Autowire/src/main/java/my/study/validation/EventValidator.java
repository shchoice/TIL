package my.study.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Event.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allowed");
    //ValidationUtils 객체 말고 직접 코딩하려면
    Event event = (Event) target;
    if (event.getTitle() == null) {
      errors.reject("Empty Title");
    }
  }
}
