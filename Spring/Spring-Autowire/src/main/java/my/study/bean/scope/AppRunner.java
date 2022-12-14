package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  Single single;

  @Autowired
  Proto proto;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 두 인스턴스가 같음을 알 수 있다.
    System.out.println(proto);
    System.out.println(single.getProto());
  }
}
