package my.study.jpabasic.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OrderItem {
  @Id @GeneratedValue
  @Column(name = "order_item_id")
  private Long id;
  @Column(name = "order_id")
  private Long orderId;
  @Column(name = "item_id")
  private Long itemId;
  int OrderPrice;
  int count;
}
