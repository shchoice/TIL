package my.study.tilspringjpabasics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import my.study.tilspringjpabasics.enumType.RoleType;

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

  @Column(name = "name")
  private String username;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  // 옛날 방식.. java 8 부터는 LocalDate, LocalDateTime 객체를 사용하자
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date createDate;
//
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date lastModifiedDate;

  private LocalDate createDate;
  private LocalDateTime lastModifiedDate;

  @Lob
  private String description;
}
/*
// hibernate.hbm2ddl.auto=create 조건으로 수행
Hibernate:
    drop table if exists Member cascade
Hibernate:
    create table Member (
        age integer,
        createDate date,
        id bigint not null,
        lastModifiedDate timestamp(6),
        name varchar(255),
        roleType varchar(255) check (roleType in ('USER','ADMIN')),
        description clob,
        primary key (id)
    )
 */