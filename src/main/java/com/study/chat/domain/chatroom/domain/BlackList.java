package com.study.chat.domain.chatroom.domain;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.member.domain.Member;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BlackList {

    private Long id;
    private ChatRoom room;
    private Member member;
    private LocalDateTime registrationAt;

    @Builder
    public BlackList(final Long id,
                     final ChatRoom room,
                     final Member member,
                     final LocalDateTime registrationAt){
        this.id = id;
        this.room = room;
        this.member = member;
        this.registrationAt = registrationAt;
    }

    public static BlackList create(final Member member,
                                   final ChatRoom room){
        return BlackList.builder()
            .room(room)
            .member(member)
            .build();
    }
}
