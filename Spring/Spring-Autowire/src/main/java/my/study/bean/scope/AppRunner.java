package my.study.bean.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ApplicationContext applicationContext;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Proto");
    System.out.println(applicationContext.getBean(Proto.class));
    System.out.println(applicationContext.getBean(Proto.class));
    System.out.println(applicationContext.getBean(Proto.class));

    System.out.println("Singleton");
    System.out.println(applicationContext.getBean(Single.class));
    System.out.println(applicationContext.getBean(Single.class));
    System.out.println(applicationContext.getBean(Single.class));

    System.out.println("Proto by Single");
    System.out.println(applicationContext.getBean(Single.class).getProto());
    System.out.println(applicationContext.getBean(Single.class).getProto());
    System.out.println(applicationContext.getBean(Single.class).getProto());
    /*
    Proto
    my.study.bean.scope.Proto@7102ac3e
    my.study.bean.scope.Proto@3f598450
    my.study.bean.scope.Proto@2db2a05f
    Singleton
    my.study.bean.scope.Single@695c938d
    my.study.bean.scope.Single@695c938d
    my.study.bean.scope.Single@695c938d
    Proto by Single
    my.study.bean.scope.Proto@d5bb1c4
    my.study.bean.scope.Proto@7ed3df3b
    my.study.bean.scope.Proto@465b38e6
     */
  }
}
