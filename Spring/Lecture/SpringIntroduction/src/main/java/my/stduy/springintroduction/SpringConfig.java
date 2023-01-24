package my.stduy.springintroduction;

import my.stduy.springintroduction.repository.MemberRepository;
import my.stduy.springintroduction.repository.MeomoryMemberRepository;
import my.stduy.springintroduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MeomoryMemberRepository();
  }
}
