package my.stduy.springintroduction.controller;

import java.util.List;
import my.stduy.springintroduction.domain.Member;
import my.stduy.springintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
    System.out.println("memberService = " + memberService.getClass());
    // memberService = class my.stduy.springintroduction.service.MemberService$$EnhancerBySpringCGLIB$$41975c14
  }

  @GetMapping(value = "/members/new")
  public String createFrom() {
    return "members/createMemberForm";
  }

  @PostMapping(value = "/members/new")
  public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName());

    memberService.join(member);

    return "redirect:/";
  }

  @GetMapping(value = "/members")
  public String list(Model model) {
    List<Member> members = memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }
}
