package com.study.chat.domain.member.controller.facade;

import com.study.chat.domain.member.controller.response.MemberInfoResponse;
import com.study.chat.domain.member.domain.Member;

public interface MemberFacade {
    MemberInfoResponse getInfo(String name);
}
