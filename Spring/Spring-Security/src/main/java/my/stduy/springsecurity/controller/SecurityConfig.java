package my.stduy.springsecurity.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests() // 요청에 대한 보안검사가 시작
        .anyRequest().authenticated(); //어떤 요청에도 인증을 받도록 함
    http
        .formLogin() // form 로그인 방식으로 인증을 할 수 있도록 함
//        .loginPage("/loginPage")
        .defaultSuccessUrl("/")
        .failureUrl("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/login_proc")
        .successHandler(new AuthenticationSuccessHandler() {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            System.out.println("authentication :" + authentication.getName());
            httpServletResponse.sendRedirect("/");
          }
        })
        .failureHandler(new AuthenticationFailureHandler() {
          @Override
          public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
            System.out.println("exception : " + e.getMessage());
            httpServletResponse.sendRedirect("/login");
          }
        })
        .permitAll(); // loginPage 페이로 접근하는 모든 사용자들은 인가를 받지 않아도 접근이 가능하도록 함
    http
        .logout()
        .logoutUrl("/logout") // 원칙적으로 POST 방식으로만 로그아웃 처리가 됨, GET 방법으로도 할 수는 있지만 별도 처리 않하면 에러 발생
        .logoutSuccessUrl("/login")
        .addLogoutHandler(new LogoutHandler() {
          @Override
          public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
            HttpSession session = httpServletRequest.getSession();
            session.invalidate();
          }
        })
        .logoutSuccessHandler(new LogoutSuccessHandler() {
          @Override
          public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
            httpServletResponse.sendRedirect("/login");
          }
        })
        .deleteCookies("remember-me")
    ;

  }
}