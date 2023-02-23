package my.study.jpabasic.advancedmapping.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorColumn
public class Book extends Item {

  private String author;
  private String isbn;
}
