package com.study.chat.domain.chatroom.service;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.dto.ChatRoomCreateDto;
import com.study.chat.domain.chatroom.service.port.ChatRoomRepository;
import com.study.chat.domain.chatroom.service.port.ChatRoomService;
import com.study.chat.domain.member.domain.Member;
import java.util.List;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoom getById(Long id) {
        return null;
    }

    @Override
    public ChatRoom create(Member member, ChatRoomCreateDto chatRoomCreateDto) {
        return null;
    }

    @Override
    public void updateParticipationNum(ChatRoom chatRoom) {

    }

    @Override
    public List<ChatRoom> findAllRooms(Member member) {
        return null;
    }

    @Override
    public void deleteRoom(Member member, ChatRoom chatRoom) {

    }
}
