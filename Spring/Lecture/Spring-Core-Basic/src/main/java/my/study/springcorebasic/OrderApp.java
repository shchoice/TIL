package my.study.springcorebasic;

import my.study.springcorebasic.AppConfig;
import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;
import my.study.springcorebasic.member.MemberService;
import my.study.springcorebasic.member.MemberServiceImpl;
import my.study.springcorebasic.order.Order;
import my.study.springcorebasic.order.OrderService;
import org.cef.OS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);
    System.out.println("order price = " + order.calculatePrice());
  }
}
