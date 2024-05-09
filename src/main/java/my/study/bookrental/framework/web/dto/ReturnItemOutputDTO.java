package my.study.bookrental.framework.web.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.study.bookrental.domain.model.vo.ReturnItem;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReturnItemOutputDTO {
    private Integer itemNo;
    private String itemTitle;
    private LocalDate returnDate;

    public static ReturnItemOutputDTO mapToDTO(ReturnItem returnItem)
    {
        ReturnItemOutputDTO rentItemOutputDTO = new ReturnItemOutputDTO();
        rentItemOutputDTO.setItemNo(returnItem.getRentalItem().getItem().getNo());
        rentItemOutputDTO.setItemTitle(returnItem.getRentalItem().getItem().getTitle());
        rentItemOutputDTO.setReturnDate(returnItem.getReturnDate());
        return rentItemOutputDTO;
    }
}
