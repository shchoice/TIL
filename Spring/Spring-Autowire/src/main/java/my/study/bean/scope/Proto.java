package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Proto {

  // Proto Type 빈에서 Singleton 빈을 참조하는 것은 전혀 문제가 없음
 @Autowired
  Single single;

}
