package my.study.bookrental.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {
  private Integer no;
  private String title;

  public static Item Sample() {
    return new Item(10, "아웃라이어");
  }
}
