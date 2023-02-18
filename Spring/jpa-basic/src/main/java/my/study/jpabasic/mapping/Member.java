package my.study.jpabasic.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue
  private Long id;
  @Column(name = "username")
  private String name;
  @ManyToOne
  @JoinColumn(name = "team_id", insertable = false, updatable = false)
  private Team team;


}

