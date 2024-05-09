package my.study.bookrental.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class IdName {
  private String id;
  private String name;

  public static IdName sample () {
    return new IdName("shchoice", "shchoi");
  }

  public static void main(String[] args) {
    System.out.println(sample().toString());
  }
}


