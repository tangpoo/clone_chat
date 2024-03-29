package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.member.domain.Member;
import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository {

    Optional<ChatRoom> getById(long id);

    List<ChatRoom> findAllRooms(Member member);

    ChatRoom save(ChatRoom chatRoom);

    void deleteById(long id);
}
