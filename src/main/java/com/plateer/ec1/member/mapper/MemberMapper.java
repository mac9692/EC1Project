package com.plateer.ec1.member.mapper;

import com.plateer.ec1.member.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> getMemberList();
}
