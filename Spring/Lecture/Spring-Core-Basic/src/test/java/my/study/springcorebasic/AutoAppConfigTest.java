package my.study.springcorebasic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import my.study.springcorebasic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {

  @Test
  void basicScan() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = context.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
    /* ComponentScan이 잘됨을 확인할 수 있음
        ClassPathBeanDefinitionScanner - Identified candidate component class:
        .. RateDiscountPolicy.class
        .. MemberServiceImpl.class
        .. MemoryMemberRepository.class
        .. OrderServiceImpl.class
     */
  }
}