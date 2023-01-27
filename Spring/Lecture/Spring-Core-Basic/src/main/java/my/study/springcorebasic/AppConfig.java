package my.study.springcorebasic;

import my.study.springcorebasic.discount.DiscountPolicy;
import my.study.springcorebasic.discount.FixDiscountPolicy;
import my.study.springcorebasic.discount.RateDiscountPolicy;
import my.study.springcorebasic.member.MemberRepository;
import my.study.springcorebasic.member.MemberService;
import my.study.springcorebasic.member.MemberServiceImpl;
import my.study.springcorebasic.member.MemoryMemberRepository;
import my.study.springcorebasic.order.OrderService;
import my.study.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(
        memberRepository(),
        discountPolicy());
  }

  public DiscountPolicy discountPolicy() {
    // return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }
}
