package my.study.bookrental.domain.model.event;

import my.study.bookrental.domain.model.vo.IdName;
import my.study.bookrental.domain.model.vo.Item;

public class ItemReturned extends ItemRented {
  public ItemReturned(IdName idName, Item item, long point) {
    super(idName, item, point);
  }

}
