package my.study.bookrental.framework.web.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.study.bookrental.domain.model.RentalItem;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentItemOutputDTO {

    private Integer itemNo;
    private String itemTitle;

    private LocalDate rentDate;
    private boolean overdued;
    //반납 예정일
    private LocalDate overdueDate;

    public static RentItemOutputDTO mapToDTO(RentalItem rentItem)
    {
        RentItemOutputDTO rentItemOutputDTO = new RentItemOutputDTO();
        rentItemOutputDTO.setItemNo(rentItem.getItem().getNo());
        rentItemOutputDTO.setItemTitle(rentItem.getItem().getTitle());
        rentItemOutputDTO.setRentDate(rentItem.getRentDate());
        rentItemOutputDTO.setOverdued(rentItem.isOverdued());
        rentItemOutputDTO.setOverdueDate(rentItem.getOverdueDate());
        return rentItemOutputDTO;
    }
}
