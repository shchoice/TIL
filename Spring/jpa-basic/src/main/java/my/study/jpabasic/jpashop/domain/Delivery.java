package my.study.jpabasic.jpashop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity{
  @Id @GeneratedValue
  private Long id;
  @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
  private Order order;
  @Embedded
  private Address address;
  @Enumerated
  private DeliveryStatus deliveryStatus;
}
