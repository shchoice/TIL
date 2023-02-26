package my.study.jpabasic.jpql.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {

  @Id @GeneratedValue
  @Column(name = "team_id")
  private long id;
  private String name;
  @OneToMany(mappedBy = "team")
  private List<Member_JPQL> members = new ArrayList<>();
}
