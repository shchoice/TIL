package my.study.springcorebasic.xml;

import static org.assertj.core.api.Assertions.assertThat;

import my.study.springcorebasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {
  @Test
  void xmlAppContext() {
//    ApplicationContext context = new GenericXmlApplicationContext("appConfig.xml");
//
//    MemberService memberService = context.getBean("memberService", MemberService.class);
//    assertThat(memberService).isInstanceOf(MemberService.class);
  }
}
