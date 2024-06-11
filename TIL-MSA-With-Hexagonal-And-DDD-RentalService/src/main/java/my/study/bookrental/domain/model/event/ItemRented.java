package my.study.bookrental.domain.model.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import my.study.bookrental.domain.model.vo.IdName;
import my.study.bookrental.domain.model.vo.Item;

@AllArgsConstructor
@Getter
public class ItemRented implements Serializable {
  private IdName idName;
  private Item item;
  private long point;
}
