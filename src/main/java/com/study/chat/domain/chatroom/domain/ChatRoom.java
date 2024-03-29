package com.study.chat.domain.chatroom.domain;

import com.study.chat.domain.chatroom.domain.ChatRoomType;
import com.study.chat.domain.chatroom.dto.ChatRoomCreateDto;
import com.study.chat.domain.member.domain.Member;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoom {

    private Long id;
    private String name;
    private ChatRoomType type;
    private String secretCode;
    private Integer maxChatRoomSize;
    private Integer participationNum;
    private LocalDateTime createdAt;
    private LocalDateTime disabledAt;
    private Member member;

    @Builder
    public ChatRoom(Long id,
                    String name,
                    ChatRoomType type,
                    String secretCode,
                    Integer maxChatRoomSize,
                    Integer participationNum,
                    LocalDateTime createdAt,
                    LocalDateTime disabledAt,
                    Member member) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.secretCode = secretCode;
        this.maxChatRoomSize = maxChatRoomSize;
        this.participationNum = participationNum;
        this.createdAt = createdAt;
        this.disabledAt = disabledAt;
        this.member = member;
    }

    public static ChatRoom create(final Member member,
                                  final ChatRoomCreateDto chatRoomCreateDto){
        return ChatRoom.builder()
            .name(chatRoomCreateDto.getName())
            .type(chatRoomCreateDto.getType())
            .secretCode(chatRoomCreateDto.getSecretKey())
            .maxChatRoomSize(chatRoomCreateDto.getMaxChatRoomSize())
            .participationNum(0)
            .member(member)
            .build();
    }

    public Long getOwnerId(){
        return member.getId();
    }

    public ChatRoom join(){
        return ChatRoom.builder()
            .id(id)
            .name(name)
            .type(type)
            .secretCode(secretCode)
            .maxChatRoomSize(maxChatRoomSize)
            .participationNum(participationNum + 1)
            .member(member)
            .build();
    }

    public ChatRoom leave(){
        return ChatRoom.builder()
            .id(id)
            .name(name)
            .type(type)
            .secretCode(secretCode)
            .maxChatRoomSize(maxChatRoomSize)
            .participationNum(Math.max(participationNum - 1, 0))
            .member(member)
            .build();
    }

    public boolean checkCode(final String code){
        return secretCode.equals(code);
    }
}
