package my.study.bookrental.framework.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserItemInputDTO {
    public String userId;
    public String userName;
    public Integer itemId;
    public String itemTitle;
}
