package my.study.jpabasic.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity {

  @Id @GeneratedValue
  private Long id;
  private String name;
  @Embedded
  private Address address;
  @OneToMany(mappedBy = "member")
  List<Order> orders = new ArrayList<>();
}
