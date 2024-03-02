package com.study.chat.domain.member.infrastructure;

import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByName(String memberName);
}
