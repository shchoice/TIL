package my.study.springcorebasic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeProviderTest {
  @Test
  void providerTest() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

    ClientBean clientBean1 = context.getBean(ClientBean.class);
    int count1 = clientBean1.logic();
    assertThat(count1).isEqualTo(1);

    ClientBean clientBean2 = context.getBean(ClientBean.class);
    int count2 = clientBean2.logic();
    assertThat(count2).isEqualTo(1);
  }

  static class ClientBean {

    @Autowired
    private ApplicationContext context;

    public int logic() {
      PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
      prototypeBean.addCount();
      int count = prototypeBean.getCount();
      return count;
    }
  }
  @Scope("prototype")
  static class PrototypeBean {

    private int count = 0;

    public void addCount() {
      count++;
    }

    public int getCount() {
      return count;
    }

    @PostConstruct
    public void init() {
      System.out.println("PrototypeBean.init " + this);
    }

    @PreDestroy
    public void destroy() {
      System.out.println("PrototypeBean.destroy");
    }
  }
}
