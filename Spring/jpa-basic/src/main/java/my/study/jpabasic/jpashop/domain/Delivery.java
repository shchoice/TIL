package my.study.jpabasic.jpashop.domain;

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
  private String city;
  private String street;
  private String zipcode;
  @Enumerated
  private DeliveryStatus deliveryStatus;
}
