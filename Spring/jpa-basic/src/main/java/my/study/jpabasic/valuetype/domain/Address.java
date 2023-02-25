package my.study.jpabasic.valuetype.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Address {

  private String city;
  private String street;
  private String zipcode;
}
