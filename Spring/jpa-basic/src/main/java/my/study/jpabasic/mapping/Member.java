package my.study.jpabasic.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

  @Id @GeneratedValue
  private Long id;
  @Column(name = "username")
  private String name;
  @Column(name = "team_id")
  private Long teamId;
}

