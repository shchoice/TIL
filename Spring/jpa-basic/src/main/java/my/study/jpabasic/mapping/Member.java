package my.study.jpabasic.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  @Column(name = "username")
  private String name;
  @ManyToOne
  @JoinColumn(name = "team_id", insertable = false, updatable = false)
  private Team team;
  @OneToOne
  @JoinColumn(name = "locker_id")
  private Locker locker;
  @ManyToMany
  @JoinTable(name = "member_product")
  private List<Product> products = new ArrayList<>();
}

