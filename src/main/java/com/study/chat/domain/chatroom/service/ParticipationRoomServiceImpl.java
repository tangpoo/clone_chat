package com.study.chat.domain.chatroom.service;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.ParticipationRoom;
import com.study.chat.domain.chatroom.service.port.ParticipationChatRoomRepository;
import com.study.chat.domain.chatroom.service.port.ParticipationRoomService;
import com.study.chat.domain.member.domain.Member;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class ParticipationRoomServiceImpl implements ParticipationRoomService {

    private final ParticipationChatRoomRepository participationRoomRepository;

    @Override
    public ParticipationRoom getByMemberAndRoom(Member member, ChatRoom room) {
        return null;
    }

    @Override
    public void join(Member member, ChatRoom room) {

    }

    @Override
    public void create(Member member, ChatRoom room) {

    }

    @Override
    public void submitSecretKey(Member member, ChatRoom room, String code) {

    }

    @Override
    public boolean isCertifiedMember(Member member, ChatRoom room) {
        return false;
    }

    @Override
    public boolean alreadyJoined(Member member, ChatRoom room) {
        return false;
    }

    @Override
    public void deleteAllByRoom(ChatRoom room) {

    }

    @Override
    public void deleteByMemberAndRoom(Member member, ChatRoom room) {

    }
}
