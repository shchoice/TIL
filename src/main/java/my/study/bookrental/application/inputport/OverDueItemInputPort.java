package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.OverdueItemUsercase;
import my.study.bookrental.domain.model.RentalCard;
import my.study.bookrental.domain.model.vo.Item;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserItemInputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OverDueItemInputPort implements OverdueItemUsercase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public RentalCardOutputDTO overDueItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.overdueItem(new Item(rental.getItemId(),rental.getItemTitle()));
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
