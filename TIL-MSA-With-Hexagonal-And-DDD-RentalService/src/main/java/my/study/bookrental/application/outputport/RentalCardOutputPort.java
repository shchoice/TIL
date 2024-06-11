package my.study.bookrental.application.outputport;

import java.util.Optional;
import my.study.bookrental.domain.model.RentalCard;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCardOutputPort {
  Optional<RentalCard> loadRentalCard(String userId);
  RentalCard save(RentalCard rentalCard);
}
