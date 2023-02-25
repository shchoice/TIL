package my.study.jpabasic.jpashop.domain;

import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class Address {
  private String city;
  private String street;
  private  String zipCode;
}
