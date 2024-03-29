package com.study.chat.domain.chatroom.service;

import static com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageType.*;

import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageDto;
import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageType;
import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatRoomInfoDto;
import com.study.chat.domain.chatroom.dto.message.ChatMessage.MemberTopicMessageDto;
import com.study.chat.domain.chatroom.service.port.ChatService;
import com.study.chat.domain.common.service.port.RedisPublish;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Builder
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final RedisPublish redisPublish;

    @Override
    public void sendChatMessage(ChatMessageDto dto) {
        redisPublish.publish("chatroom", dto);
    }

    @Override
    public void sendEnterChatRoomMessage(Long roomId, String name) {
        redisPublish.publish("chatroom",
            ChatMessageDto.builder()
                .type(NOTICE)
                .roomId(roomId)
                .sender("📣 알림")
                .message(name + " 님이 참여했습니다.")
                .build()
        );
    }

    @Override
    public void sendLeaveChatRoomMessage(Long roomId, String name) {
        redisPublish.publish("chatroom",
            ChatMessageDto.builder()
                .type(NOTICE)
                .roomId(roomId)
                .sender("📣 알림")
                .message(name + " 님이 방을 나갔습니다.")
                .build());
    }

    @Override
    public void sendMessageToMemberTopic(Long memberId, ChatMessageType type) {
        redisPublish.publish("member",
            MemberTopicMessageDto.builder()
                .type(type)
                .memberId(memberId)
                .build());
    }

    @Override
    public void sendChatRoomDelete(Long roomId) {
        redisPublish.publish("chatroom",
            ChatMessageDto.builder()
                .type(DELETE)
                .roomId(roomId)
                .build());
    }

    @Override
    public void sendChatRoomInfo(Long roomId, Integer participationNum) {
        redisPublish.publish("chatroomInfo",
            ChatRoomInfoDto.builder()
                .roomId(roomId)
                .participationNum(participationNum)
                .build());
    }
}
