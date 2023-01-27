package my.study.springcorebasic;

import my.study.springcorebasic.AppConfig;
import my.study.springcorebasic.member.Grade;
import my.study.springcorebasic.member.Member;
import my.study.springcorebasic.member.MemberService;

public class MemberApp {

  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find Member = " + findMember.getName());
  }
}