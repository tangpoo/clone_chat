package com.study.chat.domain.chatroom.controller;

import com.study.chat.domain.chatroom.controller.facade.ChatRoomFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatRoomApiController {

    private final ChatRoomFacade chatRoomFacade;
}
