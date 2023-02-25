package my.study.jpabasic.valuetype.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.study.jpabasic.mapping.Locker;
import my.study.jpabasic.mapping.MemberProduct;
import my.study.jpabasic.mapping.Team;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  @Column(name = "username")
  private String name;
  @Embedded
  private Period workPeriod;
  @Embedded
  private Address homeAddress;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="city", column = @Column(name = "work_city")),
      @AttributeOverride(name="street", column = @Column(name = "work_street")),
      @AttributeOverride(name="zipcode", column = @Column(name = "work_zipcode"))
  })
  private Address workAddress;
}

