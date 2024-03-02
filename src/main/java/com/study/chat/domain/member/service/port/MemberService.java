package com.study.chat.domain.member.service.port;

import com.study.chat.domain.member.domain.Member;

public interface MemberService {
    Member getByName(String name);
    Member getById(Long id);
}
