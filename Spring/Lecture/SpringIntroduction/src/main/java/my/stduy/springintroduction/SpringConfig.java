package my.stduy.springintroduction;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import my.stduy.springintroduction.repository.JdbcTemplateMemberRepository;
import my.stduy.springintroduction.repository.JpaMemberRepository;
import my.stduy.springintroduction.repository.MemberRepository;
import my.stduy.springintroduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final EntityManager em;

  public SpringConfig(EntityManager em) {
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new JpaMemberRepository(em);
  }
}
