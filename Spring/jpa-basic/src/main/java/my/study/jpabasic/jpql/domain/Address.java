package my.study.jpabasic.jpql.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@Embeddable
public class Address {

  private String city;
  private String street;
  private String zipcode;
}
