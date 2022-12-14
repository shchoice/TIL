package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

  // Single 빈이 싱글톤 빈이기 때문에 Proto 타입의 proto 빈을 받아도 변하지 않음 -> proto 빈은 변해야하는데 의도와 다름
  // ->
  @Autowired
  private Proto proto;

  public Proto getProto() {
    return proto;
  }
}
