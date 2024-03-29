package com.study.chat.domain.common.service.port;

import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessage;

public interface RedisPublish {
    void publish(String topic, ChatMessage chatMessage);
}
