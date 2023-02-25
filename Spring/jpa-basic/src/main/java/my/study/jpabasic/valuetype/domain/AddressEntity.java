package my.study.jpabasic.valuetype.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "address")
public class AddressEntity {
  @Id @GeneratedValue
  private Long id;
  private Address address;

  public AddressEntity(String city, String street, String zipcode) {
    this.address = new Address(city, street, zipcode);
  }
}
