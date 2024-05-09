package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.InquiryUsecase;
import my.study.bookrental.framework.web.dto.RentItemOutputDTO;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.ReturnItemOutputDTO;
import my.study.bookrental.framework.web.dto.UserInputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                .map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                .map(loadCard -> loadCard.getRentalItemList()
                        .stream()
                        .map(RentItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                .map(loadCard -> loadCard.getReturnItemLIst()
                        .stream()
                        .map(ReturnItemOutputDTO::mapToDTO)
                        .collect(Collectors.toList()));
    }
}
