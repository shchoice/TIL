package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.ClearOverdueItemUsecase;
import my.study.bookrental.domain.model.RentalCard;
import my.study.bookrental.framework.web.dto.ClearOverdueInfoDTO;
import my.study.bookrental.framework.web.dto.RentalResultOutputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
//    private final EventOutputPort eventOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.makeAvailableRental(clearOverdueInfoDTO.getPoint());

//        eventOutputPort.occurOverdueClearedEvent(RentalCard.createOverdueCleardEvent(rentalCard.getMember(),clearOverdueInfoDTO.getPoint()));

        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
