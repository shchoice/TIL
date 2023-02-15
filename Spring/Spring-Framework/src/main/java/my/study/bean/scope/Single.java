package my.study.bean.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Single {

  // Single 빈이 싱글톤 빈이기 때문에 Proto 타입의 proto 빈을 받아도 변하지 않음 -> proto 빈은 변해야하는데 의도와 다름
  @Autowired
  private ObjectProvider<Proto> proto;

  @Autowired
  ApplicationContext applicationContext;

  public Proto getProto() {
    return proto.getIfAvailable();
  }
}
