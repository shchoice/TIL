package my.stduy.springintroduction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import my.stduy.springintroduction.domain.Member;
import my.stduy.springintroduction.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;

  @Test
  void 회원가입() {
    // given
    Member member = new Member();
    member.setName("spring");

    // when
    Long saveId = memberService.join(member);

    // then
    Member findMember = memberRepository.findById(saveId).get();
    assertEquals(member.getName(), findMember.getName());
  }

  @Test
  void 중복_회원_예외() {
    // given
    Member member01= new Member();
    member01.setName("spring");

    Member member02 = new Member();
    member02.setName("spring");

    // when
    memberService.join(member01);

    try {
      memberService.join(member01);
      fail();
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member02));

    // then
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
  }
}
