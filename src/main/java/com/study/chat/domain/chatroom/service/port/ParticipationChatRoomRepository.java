package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.ParticipationRoom;
import com.study.chat.domain.member.domain.Member;
import java.util.Optional;

public interface ParticipationChatRoomRepository {
    Optional<ParticipationRoom> getByMemberAndRoom(Member member, ChatRoom room);

    void deleteByMemberAndRoom(Member member, ChatRoom chatRoom);

    void deleteAllByRoom(ChatRoom room);

    ParticipationRoom save(ParticipationRoom participationRoom);
}
