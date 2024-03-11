package my.study.tilspringjpabasics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity // JPA 가 관리하는 객체이고 DB Table과 매핑을 해서 사용하는구나 인지할 수 있음
// @Entity(name = "Member") // 다른 패키지에 같은 이름이 있는 클래스가 있는데 그것이 또 JPA와 매핑되어 있을 경우에만 사용(사용 잘 안함)
// @Table(name = "MBR") // 회사 정책으로 인해 Table 이름은 축약으로 써야한다 든가 등의 이유로 변경해야할 때 사용
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
  @Id
  private Long id;
  private  String name;
}
