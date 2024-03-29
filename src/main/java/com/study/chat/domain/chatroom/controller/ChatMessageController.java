package com.study.chat.domain.chatroom.controller;

import com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageDto;
import com.study.chat.domain.chatroom.service.port.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatService chatService;

    @MessageMapping("/chat/message")
    public void message(@RequestBody ChatMessageDto messageDto){
        chatService.sendChatMessage(messageDto);
    }
}
