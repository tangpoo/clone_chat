package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.BlackList;
import com.study.chat.domain.member.domain.Member;
import java.util.Optional;

public interface BlackListRepository {
    BlackList save(BlackList blackList);
    Optional<BlackList> findByRoomAndMember(ChatRoom room, Member member);
}
