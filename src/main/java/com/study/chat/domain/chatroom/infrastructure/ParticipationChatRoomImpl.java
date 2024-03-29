package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.ParticipationRoom;
import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.chatroom.infrastructure.entity.ParticipationRoomEntity;
import com.study.chat.domain.chatroom.service.port.ParticipationChatRoomRepository;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParticipationChatRoomImpl implements ParticipationChatRoomRepository {

    private final ParticipationChatRoomJpaRepository participationChatRoomJpaRepository;

    @Override
    public Optional<ParticipationRoom> getByMemberAndRoom(Member member, ChatRoom room) {
        return participationChatRoomJpaRepository
            .getByMemberAndRoom(MemberEntity.fromModel(member), ChatRoomEntity.fromModel(room))
            .stream()
            .map(ParticipationRoomEntity::toModel)
            .findAny();
    }

    @Override
    public void deleteByMemberAndRoom(Member member, ChatRoom chatRoom) {
        participationChatRoomJpaRepository.deleteByMemberAndRoom(
            MemberEntity.fromModel(member),
            ChatRoomEntity.fromModel(chatRoom)
        );
    }

    @Override
    public void deleteAllByRoom(ChatRoom room) {
        participationChatRoomJpaRepository.deleteAllByRoom(ChatRoomEntity.fromModel(room));
    }

    @Override
    public ParticipationRoom save(ParticipationRoom participationRoom) {
        return participationChatRoomJpaRepository.save(ParticipationRoomEntity.from(participationRoom)).toModel();
    }
}
