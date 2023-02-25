package my.study.jpabasic.valuetype.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.study.jpabasic.mapping.Locker;
import my.study.jpabasic.mapping.MemberProduct;
import my.study.jpabasic.mapping.Team;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Member {

  @Id @GeneratedValue
  @Column(name = "member_id")
  private Long id;
  @Column(name = "username")
  private String name;
  @Embedded
  private Period workPeriod;
  @Embedded
  private Address homeAddress;
  @ElementCollection
  @CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name = "member_id"))
  private Set<String> favoriteFoods = new HashSet<>();
//  @ElementCollection
//  @CollectionTable(name = "address_history", joinColumns = @JoinColumn(name = "member_id"))
//  private List<Address> addresseHistory = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "member_id")
  private List<AddressEntity> addresseHistory = new ArrayList<>();
}

