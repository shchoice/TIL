package my.study.bookrental.application.usecase;

import my.study.bookrental.framework.web.dto.RentalCardOutputDTO;
import my.study.bookrental.framework.web.dto.UserItemInputDTO;

public interface ReturnItemUsecase {
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception;
}
