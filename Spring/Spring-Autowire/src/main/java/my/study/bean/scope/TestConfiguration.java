package my.study.bean.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") // 해당 빈 설정 파일은 test 프로파일일 때만 사용 가능
// 어플리케이션의 run/debug configuation 에서 Active profiles에 test라고 적어 넣으면 사용 가능
// 어플리케이션의 run/debug configuration 에서 VM options에 -Dspring.profiles.active="test" 라고 해도 됨
public class TestConfiguration {
  @Bean
  public BookRepository bookRepository() {
    return new TestBookRepository();
  }
}
