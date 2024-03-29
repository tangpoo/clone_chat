package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.dto.ChatRoomCreateDto;
import com.study.chat.domain.member.domain.Member;
import java.util.List;

public interface ChatRoomService {

    ChatRoom getById(Long id);

    ChatRoom create(Member member, ChatRoomCreateDto chatRoomCreateDto);

    void updateParticipationNum(ChatRoom chatRoom);

    List<ChatRoom> findAllRooms(Member member);

    void deleteRoom(Member member, ChatRoom chatRoom);
}
