package my.stduy.springsecurity.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests() // 요청에 대한 보안검사가 시작
        .anyRequest().authenticated(); //어떤 요청에도 인증을 받도록 함
    http
        .formLogin(); // form 로그인 방식으로 인증을 할 수 있도록 함
  }
}
