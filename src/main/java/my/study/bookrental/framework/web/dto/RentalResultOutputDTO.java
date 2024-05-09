package my.study.bookrental.framework.web.dto;

import lombok.Getter;
import lombok.Setter;
import my.study.bookrental.domain.model.RentalCard;

@Getter
@Setter
public class RentalResultOutputDTO {
    public String userId;
    public String userName;
    public Integer rentedCount;
    public long totalLateFee;

    public static RentalResultOutputDTO mapToDTO(RentalCard rental){
        RentalResultOutputDTO rentDTO = new RentalResultOutputDTO();
        rentDTO.setUserId(rental.getMember().getId());
        rentDTO.setUserName(rental.getMember().getName());
        rentDTO.setRentedCount(rental.getRentalItemList().size());
        rentDTO.setTotalLateFee(rental.getLateFee().getPoint());
        return rentDTO;
    }
}

