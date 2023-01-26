package my.study.springcorebasic.discount;

import my.study.springcorebasic.member.Member;

public interface DiscountPolicy {
  int discount (Member member, int price);
}
