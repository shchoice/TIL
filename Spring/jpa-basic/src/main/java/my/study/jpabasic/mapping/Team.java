package my.study.jpabasic.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {

  @Id @GeneratedValue
  @Column(name = "team_id")
  private Long id;
  private String name;
  @OneToMany
  @JoinColumn(name = "team_id")
  List<Member> members = new ArrayList<>();
  //    alter table member
  //       add constraint FKcjte2jn9pvo9ud2hyfgwcja0k
  //       foreign key (team_id)
  //       references team
}
