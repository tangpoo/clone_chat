package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.chatroom.infrastructure.entity.ParticipationRoomEntity;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationChatRoomJpaRepository extends
    JpaRepository<ParticipationRoomEntity, Long> {

    Optional<ParticipationRoomEntity> getByMemberAndRoom(MemberEntity memberEntity,
        ChatRoomEntity room);

    void deleteByMemberAndRoom(MemberEntity memberEntity, ChatRoomEntity room);

    void deleteAllByRoom(ChatRoomEntity room);

    Optional<ParticipationRoomEntity> getByRoom(ChatRoomEntity room);
}
