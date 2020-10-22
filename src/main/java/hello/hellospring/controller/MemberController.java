package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자를 통한 의존성 주입(DI)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
