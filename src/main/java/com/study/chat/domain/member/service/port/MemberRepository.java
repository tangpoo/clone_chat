package com.study.chat.domain.member.service.port;

import com.study.chat.domain.member.domain.Member;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> getById(Long id);
    Optional<Member> getByName(String name);
    Member save(Member member);
}
