package my.study.bookrental.domain.model.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.study.bookrental.domain.model.vo.IdName;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OverdueCleared implements Serializable {
    private IdName idName;
    private long point;
}
