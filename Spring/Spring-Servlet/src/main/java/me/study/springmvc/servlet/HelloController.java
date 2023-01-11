package me.study.springmvc.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Servelt 에서 Spring MVC가 되기 위해서는..
 * 어떤 요청을 처리하는 Handler를 GetMapping으로 처리하도록 만들어야함.
 * -> 즉 핸들러 쪽으로 요청을 dispatch 해주고, 애노테인션을 이해하고, 응답로 HTTP return을 HTTP Response로 리턴해줄 수 있는 DispatcherServlet을 써야함!
 */
@Controller
//@RestController : @ResponseBody를 사용한 Controlller 와 동일
public class HelloController {

  @Autowired
  HelloService helloService;

  @GetMapping("/hello")
  @ResponseBody
  public String hello() {
    return "Hello, " + helloService.getName();
  }

  @GetMapping("/sample")
  public String sample() {
    return "/WEB-INF/sample.jsp";
  }

}
