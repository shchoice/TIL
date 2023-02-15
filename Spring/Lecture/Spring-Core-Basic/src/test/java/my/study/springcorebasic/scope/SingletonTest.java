package my.study.springcorebasic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {
  @Test
  public void singletonBeanFind() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingletonBean.class);

    SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
    SingletonBean singletonBean2 = context.getBean(SingletonBean.class);

    System.out.println("singletonBean1 = " + singletonBean1);
    System.out.println("singletonBean2 = " + singletonBean2);
    assertThat(singletonBean1).isSameAs(singletonBean2);
    context.close(); //종료
  }
  @Scope("singleton")
  static class SingletonBean {
    @PostConstruct
    public void init() {
      System.out.println("SingletonBean.init");
    }
    @PreDestroy
    public void destroy() {
      System.out.println("SingletonBean.destroy");
    }
  }
}
