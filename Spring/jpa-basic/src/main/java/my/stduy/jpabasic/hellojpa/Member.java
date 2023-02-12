package my.stduy.jpabasic.hellojpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class Member {

  @Id
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

  /*
      create table Member (
       id bigint not null,
        age integer,
        createDate timestamp,
        description clob,
        lastModifiedDate timestamp,
        roleType varchar(255),
        name varchar(255),
        primary key (id)
    )
   */

}
