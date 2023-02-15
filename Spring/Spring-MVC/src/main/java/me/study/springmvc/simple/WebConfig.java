package me.study.springmvc.simple;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  // Spring Boot에서는 해당 작업을 하지 않아도 됨.
  // Formatter 가 빈으로 등록이 되어져 있으면 자동적으로 처리를 해주기 때문
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addFormatter(new PersonFormatter());
  }
}
