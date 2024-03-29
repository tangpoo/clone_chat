package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.member.domain.Member;

public interface BlackListService {
    void create(ChatRoom room, Member banMember);

    boolean isMemberInBlackList(Member member, ChatRoom room);
}
