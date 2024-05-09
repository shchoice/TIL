package my.study.bookrental.domain.model.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.study.bookrental.domain.model.RentalItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReturnItem {
  @Embedded
  private RentalItem rentalItem;
  private LocalDate returnDate;

  public static ReturnItem createReturnItem(RentalItem rentalItem){
    return new ReturnItem(rentalItem, LocalDate.now());
  }

  public static ReturnItem sample(){
    return ReturnItem.createReturnItem(RentalItem.sample());
  }
}
