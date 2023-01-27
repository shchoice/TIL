package my.study.springcorebasic;

import my.study.springcorebasic.discount.FixDiscountPolicy;
import my.study.springcorebasic.member.MemberService;
import my.study.springcorebasic.member.MemberServiceImpl;
import my.study.springcorebasic.member.MemoryMemberRepository;
import my.study.springcorebasic.order.OrderService;
import my.study.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService() {
    return new OrderServiceImpl(
        new MemoryMemberRepository(),
        new FixDiscountPolicy());
  }
}
