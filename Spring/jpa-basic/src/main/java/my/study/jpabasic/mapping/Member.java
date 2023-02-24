package my.study.jpabasic.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member extends BaseEntity {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  @Column(name = "username")
  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn
  private Team team;
  @OneToOne
  @JoinColumn(name = "locker_id")
  private Locker locker;
  @OneToMany(mappedBy = "member")
  private List<MemberProduct> memberProducts = new ArrayList<>();
}

