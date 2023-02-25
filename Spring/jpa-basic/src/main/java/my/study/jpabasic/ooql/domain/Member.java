package my.study.jpabasic.ooql.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.study.jpabasic.valuetype.domain.Address;
import my.study.jpabasic.valuetype.domain.AddressEntity;
import my.study.jpabasic.valuetype.domain.Period;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Member {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  @Column(name = "username")
  private String name;

}

