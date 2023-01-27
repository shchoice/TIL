package my.study.springcorebasic.beanfind;

import my.study.springcorebasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean() {
    String[] beanDefinitionNames = context.getBeanDefinitionNames();

    for (String beanDefinitionName: beanDefinitionNames) {
      BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);
      Object bean = context.getBean(beanDefinitionName);
      System.out.println("name = " + beanDefinitionName + " object = " + bean);
      /*
        name = org.springframework.context.annotation.internalConfigurationAnnotationProcessor object = org.springframework.context.annotation.ConfigurationClassPostProcessor@4201a617
        name = org.springframework.context.annotation.internalAutowiredAnnotationProcessor object = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@467f77a5
        name = org.springframework.context.annotation.internalCommonAnnotationProcessor object = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@1bb9aa43
        name = org.springframework.context.event.internalEventListenerProcessor object = org.springframework.context.event.EventListenerMethodProcessor@420bc288
        name = org.springframework.context.event.internalEventListenerFactory object = org.springframework.context.event.DefaultEventListenerFactory@df5f5c0
        name = appConfig object = my.study.springcorebasic.AppConfig$$EnhancerBySpringCGLIB$$3b7649e5@308a6984
        name = memberRepository object = my.study.springcorebasic.member.MemoryMemberRepository@66b72664
        name = memberService object = my.study.springcorebasic.member.MemberServiceImpl@7a34b7b8
        name = orderService object = my.study.springcorebasic.order.OrderServiceImpl@58cd06cb
        name = discountPolicy object = my.study.springcorebasic.discount.RateDiscountPolicy@3be8821f
      */
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean() {
    String[] beanDefinitionNames = context.getBeanDefinitionNames();
    for (String beanDefinitionName: beanDefinitionNames) {
      BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);

      //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
      //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object bean = context.getBean(beanDefinitionName);
        System.out.println("name = " + beanDefinitionName + " object = " + bean);
        /*
          name = appConfig object = my.study.springcorebasic.AppConfig$$EnhancerBySpringCGLIB$$3b7649e5@308a6984
          name = memberRepository object = my.study.springcorebasic.member.MemoryMemberRepository@66b72664
          name = memberService object = my.study.springcorebasic.member.MemberServiceImpl@7a34b7b8
          name = orderService object = my.study.springcorebasic.order.OrderServiceImpl@58cd06cb
          name = discountPolicy object = my.study.springcorebasic.discount.RateDiscountPolicy@3be8821f
        */
      }
    }
  }
}
