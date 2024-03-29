package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.ParticipationRoom;
import com.study.chat.domain.member.domain.Member;

public interface ParticipationRoomService {
    ParticipationRoom getByMemberAndRoom(Member member, ChatRoom room);

    void join(Member member, ChatRoom room);

    void create(Member member, ChatRoom room);

    void submitSecretKey(Member member, ChatRoom room, String code);

    boolean isCertifiedMember(Member member, ChatRoom room);

    boolean alreadyJoined(Member member, ChatRoom room);

    void deleteAllByRoom(ChatRoom room);

    void deleteByMemberAndRoom(Member member, ChatRoom room);
}
