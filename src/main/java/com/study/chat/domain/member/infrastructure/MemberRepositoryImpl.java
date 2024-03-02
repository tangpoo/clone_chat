package com.study.chat.domain.member.infrastructure;

import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import com.study.chat.domain.member.service.port.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Optional<Member> getById(Long id) {
        return memberJpaRepository.findById(id).map(MemberEntity::toModel);
    }

    @Override
    public Optional<Member> getByName(String name) {
        return memberJpaRepository
            .findByName(name).map(MemberEntity::toModel);
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository
            .save(MemberEntity.fromModel(member))
            .toModel();
    }
}
