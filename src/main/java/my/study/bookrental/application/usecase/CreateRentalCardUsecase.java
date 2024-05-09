package my.study.bookrental.application.usecase;

import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserInputDTO;

public interface CreateRentalCardUsecase {
  public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO);
}
