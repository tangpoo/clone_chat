package com.study.chat.domain.chatroom.controller.facade;

import com.study.chat.domain.chatroom.controller.dto.response.ChatRoomInfoResponseDto;
import com.study.chat.domain.chatroom.dto.ChatRoomCreateDto;
import java.util.List;

public interface ChatRoomFacade {
    ChatRoomInfoResponseDto create(ChatRoomCreateDto chatRoomCreateDto);
    void enter(Long memberId, Long roomId);
    void leave(Long memberId, Long roomId);
    void ban(String memberName, Long roomId);
    void delete(Long memberId, Long roomId);
    void submitCode(Long memberId, Long roomId, String code);
    ChatRoomInfoResponseDto getById(Long roomId);
    List<ChatRoomInfoResponseDto> findAllRooms(String memberName);
    PerMissionType checkPermission(Long roomId, Long memberId);
}
