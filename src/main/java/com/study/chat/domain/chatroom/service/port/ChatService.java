package com.study.chat.domain.chatroom.service.port;

import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageDto;
import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageType;

public interface ChatService {
    void sendChatMessage(ChatMessageDto dto);

    void sendEnterChatRoomMessage(Long roomId, String name);

    void sendLeaveChatRoomMessage(Long roomId, String name);

    void sendMessageToMemberTopic(Long memberId, ChatMessageType type);

    void sendChatRoomDelete(Long roomId);

    void sendChatRoomInfo(Long roomId, Integer participationNum);
}
