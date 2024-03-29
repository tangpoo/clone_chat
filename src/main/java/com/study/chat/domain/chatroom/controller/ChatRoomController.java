package com.study.chat.domain.chatroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    @GetMapping("/room")
    public String room(){
        return "/chat/room";
    }

    @GetMapping("/room/{roomId}")
    public String roomDetail(){
        return "/chat/roomDetail";
    }
}
