package my.study.springcorebasic.discount;

import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1000;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    else {
      return 0;
    }
  }
}
