package my.study.jpabasic.mapping;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberProduct {
  @Id @GeneratedValue
  private Long id;
  @ManyToOne
  @JoinColumn(name="member_id")
  private Member member;
  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;
  private int count;
  private int price;
  private LocalDateTime orderDateTime;
}
