package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.domain.BlackList;
import com.study.chat.domain.chatroom.infrastructure.entity.BlackListEntity;
import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListJpaRepository extends JpaRepository<BlackListEntity, Long> {
    Optional<BlackListEntity> findByRoomAndMember(ChatRoomEntity room, MemberEntity memberEntity);
}
