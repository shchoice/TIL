package my.study.springcorebasic.order;

import static org.junit.jupiter.api.Assertions.*;

import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;
import my.study.springcorebasic.member.MemberService;
import my.study.springcorebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

  MemberService memberService = new MemberServiceImpl();
  OrderService orderService = new OrderServiceImpl();

  @Test
  void createOrder() {
    long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);

    memberService.join(member);
    Order order = orderService.createOrder(memberId, "itemA", 10000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}