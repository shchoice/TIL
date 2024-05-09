package my.study.bookrental.application.usecase;

import java.util.List;
import java.util.Optional;
import my.study.bookrental.framework.web.dto.RentItemOutputDTO;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.ReturnItemOutputDTO;
import my.study.bookrental.framework.web.dto.UserInputDTO;

public interface InquiryUsecase {
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO);
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);
}
