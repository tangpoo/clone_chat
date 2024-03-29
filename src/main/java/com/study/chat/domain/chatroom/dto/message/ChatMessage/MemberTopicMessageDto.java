package com.study.chat.domain.chatroom.dto.message.ChatMessage;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberTopicMessageDto implements ChatMessage{

    private ChatMessageType type;
    private Long memberId;

    @Builder
    public MemberTopicMessageDto(final ChatMessageType type,
                                 final Long memberId) {
        this.type = type;
        this.memberId = memberId;
    }
}
