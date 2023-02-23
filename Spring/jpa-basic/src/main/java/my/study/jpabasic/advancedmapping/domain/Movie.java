package my.study.jpabasic.advancedmapping.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorColumn
public class Movie extends Item {

  private String director;
  private String actor;
}
