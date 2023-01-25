package my.stduy.springintroduction;

import javax.sql.DataSource;
import my.stduy.springintroduction.repository.JdbcMemberRepository;
import my.stduy.springintroduction.repository.MemberRepository;
import my.stduy.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private final DataSource dataSource;

  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }


  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new JdbcMemberRepository(dataSource);
  }
}
