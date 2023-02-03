package my.study.springjpaexapp01.firstExample;


import static org.assertj.core.api.Assertions.assertThat;

import my.study.springjpaexapp01.firstExample.Member;
import my.study.springjpaexapp01.firstExample.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  @Transactional
  @Rollback(value = false)
  public void testMember() {
    // given
    Member member = new Member();
    member.setUsername("memberA");

    //when
    Long savedId = memberRepository.save(member);
    Member findMember = memberRepository.find(savedId);

    // then
    assertThat(findMember.getId()).isEqualTo(member.getId());
    assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    assertThat(findMember).isEqualTo(member); // JPA 엔티티 동일성 보장
    System.out.println("findMember == member: " + (findMember == member)); // true
  }
}