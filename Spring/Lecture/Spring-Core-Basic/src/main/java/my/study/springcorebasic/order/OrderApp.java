package my.study.springcorebasic.order;

import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;
import my.study.springcorebasic.member.MemberService;
import my.study.springcorebasic.member.MemberServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);
    System.out.println("order price = " + order.calculatePrice());
  }
}
