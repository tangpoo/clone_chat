package com.study.chat.domain.chatroom.service;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.BlackList;
import com.study.chat.domain.chatroom.service.port.BlackListRepository;
import com.study.chat.domain.chatroom.service.port.BlackListService;
import com.study.chat.domain.member.domain.Member;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Builder
@RequiredArgsConstructor
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository blackListRepository;

    @Override
    @Transactional
    public void create(ChatRoom room, Member member) {
        BlackList blackList = BlackList.create(member, room);
        blackListRepository.save(blackList);
    }

    @Override
    public boolean isMemberInBlackList(Member member, ChatRoom room) {
        return blackListRepository.findByRoomAndMember(room, member).isPresent();
    }
}
