package my.study.springcorebasic.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import my.study.springcorebasic.AppConfig;
import my.study.springcorebasic.member.MemberRepository;
import my.study.springcorebasic.member.MemberServiceImpl;
import my.study.springcorebasic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    //모두 같은 인스턴스를 참고하고 있다.
    System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
    System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
    System.out.println("memberRepository = " + memberRepository);

    //모두 같은 인스턴스를 참고하고 있다.
    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }

  @Test
  void configurationDeep() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    //AppConfig도 스프링 빈으로 등록된다.
    AppConfig bean = context.getBean(AppConfig.class);

    System.out.println("bean = " + bean.getClass());
    //출력: bean = class my.study.springcorebasic.AppConfig$$EnhancerBySpringCGLIB$$64b36c23
  }
}
