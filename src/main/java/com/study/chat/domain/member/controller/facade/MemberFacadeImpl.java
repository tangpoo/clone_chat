package com.study.chat.domain.member.controller.facade;

import com.study.chat.domain.common.service.port.TokenHolder;
import com.study.chat.domain.member.controller.response.MemberInfoResponse;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.service.port.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFacadeImpl implements MemberFacade {

    private final MemberService memberService;
    private final TokenHolder tokenHolder;

    @Override
    public MemberInfoResponse getInfo(String name) {
        Member member = memberService.getByName(name);
        String token = tokenHolder.generateToken(name);

        return MemberInfoResponse.from(member, token);
    }
}
