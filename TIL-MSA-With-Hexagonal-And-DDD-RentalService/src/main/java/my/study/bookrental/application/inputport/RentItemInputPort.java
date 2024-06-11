package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.RentItemUsecase;
import my.study.bookrental.domain.model.RentalCard;
import my.study.bookrental.domain.model.vo.IdName;
import my.study.bookrental.domain.model.vo.Item;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserItemInputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
//    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseGet(() -> RentalCard.createRentalCard(new IdName(rental.getUserId(), rental.getUserName())));

        Item newItem = new Item(rental.getItemId(),rental.getItemTitle());
        rentalCard.rentItem(newItem);

        // mybatis, sql mapper 등 예전 기술 사용 시
//        RentalCard save = rentalCardOutputPort.save(rentalCard);
//        return RentalCardOutputDTO.mapToDTO(save);

        return RentalCardOutputDTO.mapToDTO(rentalCard);

//        //대여 이벤트 생성 및 발행
//        ItemRented itemRentedEvent = RentalCard.createItemRentedEvent(rentalCard.getMember(), newItem, 10L);
//        eventOutputPort.occurRentalEvent(itemRentedEvent);

//        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
