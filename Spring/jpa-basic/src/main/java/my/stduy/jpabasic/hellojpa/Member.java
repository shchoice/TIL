package my.stduy.jpabasic.hellojpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1) // Hibernate: create sequence MEMBER_SEQ_GENERATOR start with 1 increment by 50
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") // id bigint not null,
  private Long id;
  @Column(name = "name")
  private String username;
  private Integer age;
  @Enumerated(EnumType.STRING)
  private RoleType roleType;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
  @Lob
  private String description;

}
