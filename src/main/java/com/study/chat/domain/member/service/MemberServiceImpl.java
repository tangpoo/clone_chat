package com.study.chat.domain.member.service;

import com.study.chat.domain.common.exception.CustomNoSuchElementException;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.service.port.MemberRepository;
import com.study.chat.domain.member.service.port.MemberService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member getByName(String name) {
        return memberRepository.getByName(name)
            .orElseThrow(CustomNoSuchElementException::new);
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.getById(id)
            .orElseThrow(CustomNoSuchElementException::new);
    }
}
