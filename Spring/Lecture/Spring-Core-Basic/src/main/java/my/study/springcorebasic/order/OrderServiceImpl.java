package my.study.springcorebasic.order;

import lombok.RequiredArgsConstructor;
import my.study.springcorebasic.discount.DiscountPolicy;
import my.study.springcorebasic.member.Member;
import my.study.springcorebasic.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName , itemPrice, discountPrice);
  }

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
