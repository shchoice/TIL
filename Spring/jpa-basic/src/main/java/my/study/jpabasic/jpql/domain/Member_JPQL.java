package my.study.jpabasic.jpql.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@Table(name = "MEMBER")
public class Member_JPQL {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private long id;
  private String username;
  private int age;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;
  @OneToMany
  @JoinColumn(name = "member_id")
  private List<Order> orders = new ArrayList<>();

  public void changeTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }
}
