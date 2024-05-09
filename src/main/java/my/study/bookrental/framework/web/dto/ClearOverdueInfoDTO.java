package my.study.bookrental.framework.web.dto;

import lombok.Getter;

@Getter
public class ClearOverdueInfoDTO {
    public String userId;
    public String userName;
    public Integer point;
}
