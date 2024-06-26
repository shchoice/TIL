package my.study.springcorebasic.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import my.study.springcorebasic.discount.DiscountPolicy;
import my.study.springcorebasic.discount.FixDiscountPolicy;
import my.study.springcorebasic.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class ApplicationContextExtendsFindTest {

  @Configuration
  static class TestConfig {
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }
    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
  }

  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
  void findBeanByParentTypeDuplicate() {
    //DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    assertThrows(NoUniqueBeanDefinitionException.class, () ->
        context.getBean(DiscountPolicy.class));
  }

  @Test
  @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
  void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = context.getBean("rateDiscountPolicy", DiscountPolicy.class);
    assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }

  @Test
  @DisplayName("특정 하위 타입으로 조회")
  void findBeanBySubType() {
    RateDiscountPolicy bean = context.getBean(RateDiscountPolicy.class);
    assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
  }
  @Test
  @DisplayName("부모 타입으로 모두 조회하기")
  void findAllBeanByParentType() {
    Map<String, DiscountPolicy> beansOfType = context.getBeansOfType(DiscountPolicy.class);
    assertThat(beansOfType.size()).isEqualTo(2);
    for (String key : beansOfType.keySet()) {
      System.out.println("1. key = " + key + " value=" + beansOfType.get(key));
    }
  }

  @Test
  @DisplayName("부모 타입으로 모두 조회하기 - Object")
  void findAllBeanByObjectType() {
    Map<String, Object> beansOfType = context.getBeansOfType(Object.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("2. key = " + key + " value=" + beansOfType.get(key));
    }
  }
}
