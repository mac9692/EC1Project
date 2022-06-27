package com.plateer.ec1.member.service.impl;

import com.plateer.ec1.member.mapper.MemberMapper;
import com.plateer.ec1.member.service.MemberService;
import com.plateer.ec1.member.vo.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<Member> getMemberList() {
        log.info("Member 조회 서비스 호출");
        return memberMapper.getMemberList();
    }
}
