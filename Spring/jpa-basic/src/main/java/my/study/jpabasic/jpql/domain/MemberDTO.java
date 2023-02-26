package my.study.jpabasic.jpql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MemberDTO {
  private String username;
  private int age;
}
