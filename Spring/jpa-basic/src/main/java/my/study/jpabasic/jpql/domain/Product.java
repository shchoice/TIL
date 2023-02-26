package my.study.jpabasic.jpql.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

  @Id @GeneratedValue
  @Column(name = "product_id")
  private Long id;
  private String name;
  private int price;
  private int stockAmount;
  @OneToMany(mappedBy = "product")
  private List<Order> orders = new ArrayList<>();
}
