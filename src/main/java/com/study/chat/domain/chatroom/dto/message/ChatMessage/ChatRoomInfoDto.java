package com.study.chat.domain.chatroom.dto.message.ChatMessage;

import static com.study.chat.domain.chatroom.dto.message.ChatMessage.ChatMessageType.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomInfoDto implements ChatMessage{

    private ChatMessageType type;
    private Long roomId;
    private Integer participationNum;

    @Builder
    public ChatRoomInfoDto(final Long roomId,
                           final Integer participationNum){
        this.type = INFO;
        this.roomId = roomId;
        this.participationNum = participationNum;
    }
}
