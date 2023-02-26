package my.study.jpabasic.jpql.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "ORDERS")
public class Order {

  @Id @GeneratedValue
  @Column(name = "order_id")
  private long id;
  private int orderAmount;
  @Embedded
  private Address address;
  @ManyToOne(fetch = FetchType.LAZY)
  private Member_JPQL member;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
}
