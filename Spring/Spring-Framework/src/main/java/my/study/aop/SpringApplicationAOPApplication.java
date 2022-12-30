package my.study.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationAOPApplication {

  public static void main(String[] args) {
    // 웹 서버를 기동시키지 않는 형태로 실행 시킴
    SpringApplication app = new SpringApplication(SpringApplicationAOPApplication.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.run(args);
//    SpringApplication.run(SpringApplicationAOPApplication.class, args);
  }
}
