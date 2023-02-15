package my.stduy.springintroduction.service;

import java.util.List;
import java.util.Optional;
import my.stduy.springintroduction.domain.Member;
import my.stduy.springintroduction.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원 가입
   */
  public Long join(Member member) {
//    Optional<Member> result = memberRepository.findByName(member.getName());
//    result.ifPresent(m -> {
//      throw new IllegalStateException("이미 존재하는 회원입니다.");
//    });

    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
  }

  /**
   * 전체 회원 조회
   */

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
