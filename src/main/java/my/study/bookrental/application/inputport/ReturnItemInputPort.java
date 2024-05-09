package my.study.bookrental.application.inputport;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import my.study.bookrental.application.outputport.RentalCardOutputPort;
import my.study.bookrental.application.usecase.ReturnItemUsecase;
import my.study.bookrental.domain.model.RentalCard;
import my.study.bookrental.domain.model.vo.Item;
import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserItemInputDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
//    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception {
        // OutputPort를 사용해서 rentalCard 검색한 후 없으면 Exception처리, 있으면 도서 반납
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDto.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        Item retrunItem = new Item(returnDto.getItemId(),returnDto.getItemTitle());
        rentalCard.returnItem(retrunItem, LocalDate.now());
//        //이벤트 생성 발행
//        ItemReturned itemReturnEvent = RentalCard.createItemReturnEvent(rentalCard.getMember(), retrunItem, 10L);
//        eventOutputPort.occurReturnEvent(itemReturnEvent);

        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
