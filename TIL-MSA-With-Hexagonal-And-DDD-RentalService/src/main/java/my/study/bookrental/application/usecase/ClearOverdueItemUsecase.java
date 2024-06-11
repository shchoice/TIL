package my.study.bookrental.application.usecase;

import my.study.bookrental.framework.web.dto.ClearOverdueInfoDTO;
import my.study.bookrental.framework.web.dto.RentalResultOutputDTO;

public interface ClearOverdueItemUsecase {
    RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
