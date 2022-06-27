package com.plateer.ec1.member.controller;

import com.plateer.ec1.member.service.MemberService;
import com.plateer.ec1.member.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "api")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(path = "memberList")
    public List<Member> getMemberList() {
        log.info("Member 조회 시작");
        return memberService.getMemberList();
    }
}
