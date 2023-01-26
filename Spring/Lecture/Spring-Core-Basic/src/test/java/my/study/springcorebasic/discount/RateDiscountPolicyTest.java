package my.study.springcorebasic.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP 회원은 10% 할인이 적용 되어야 함")
  void vip_discount() {
    //given
    Member member = new Member(1L, "memberVIP", Grade.VIP);
    //when
    int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP가 아닌 회원은 10% 할인이 적용 되어야 함")
  void non_vip_discount() {
    //given
    Member member = new Member(2L, "memberBASIC", Grade.BASIC);
    //when
    int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(0);
  }
}