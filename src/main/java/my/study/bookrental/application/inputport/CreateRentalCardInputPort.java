package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.CreateRentalCardUsecase;
import my.study.bookrental.domain.model.RentalCard;
import my.study.bookrental.domain.model.vo.IdName;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserInputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

  private final RentalCardOutputPort rentalCardOutputPort;

  @Override
  public RentalCardOutputDTO createRentalCard(UserInputDTO owner) {
    RentalCard rentalCard = RentalCard.createRentalCard(new IdName(owner.getUserId(), owner.getUserName()));
    RentalCard save = rentalCardOutputPort.save(rentalCard);
    return RentalCardOutputDTO.mapToDTO(save);  }
}
