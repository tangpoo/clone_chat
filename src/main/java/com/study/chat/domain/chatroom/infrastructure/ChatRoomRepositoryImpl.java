package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.chatroom.service.port.ChatRoomRepository;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepositoryImpl implements ChatRoomRepository {

    private final ChatRoomJpaRepository chatRoomJpaRepository;

    @Override
    public Optional<ChatRoom> getById(long id) {
        return chatRoomJpaRepository.findById(id).map(ChatRoomEntity::toModel);
    }

    @Override
    public List<ChatRoom> findAllRooms(Member member) {
        return chatRoomJpaRepository
            .findRoomsNotInBlacklistForMemberEntity(MemberEntity.fromModel(member))
            .stream().map(ChatRoomEntity::toModel)
            .toList();
    }

    @Override
    public ChatRoom save(ChatRoom chatRoom) {
        return chatRoomJpaRepository.save(ChatRoomEntity.fromModel(chatRoom)).toModel();
    }

    @Override
    public void deleteById(long id) {
        chatRoomJpaRepository.deleteById(id);
    }
}
