package com.study.chat.domain.chatroom.infrastructure.entity;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.ChatRoomType;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "update rooms set disabled_at = CURRENT_TIMESTAMP where id = ?")
@Table(name = "rooms")
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_private")
    private Boolean isPrivate;

    @Column(name = "secret_code")
    private String secretCode;

    @Column(name = "max_chat_room_size")
    private Integer maxChatRoomSize;

    @Column(name = "participation_num")
    private Integer participationNum;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createAt;

    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;

    @ManyToOne
    @JoinColumn(name = "member")
    private MemberEntity member;

    public static ChatRoomEntity fromModel(ChatRoom chatRoom) {
        return ChatRoomEntity.builder()
            .id(chatRoom.getId())
            .name(chatRoom.getName())
            .isPrivate(chatRoom.getType().equals(ChatRoomType.PRIVATE))
            .secretCode(chatRoom.getSecretCode())
            .maxChatRoomSize(chatRoom.getMaxChatRoomSize())
            .participationNum(chatRoom.getParticipationNum())
            .member(MemberEntity.fromModel(chatRoom.getMember()))
            .build();
    }

    public ChatRoom toModel() {
        return ChatRoom.builder()
            .id(id)
            .name(name)
            .type(isPrivate ? ChatRoomType.PRIVATE : ChatRoomType.PUBLIC)
            .secretCode(secretCode)
            .maxChatRoomSize(maxChatRoomSize)
            .participationNum(participationNum)
            .createdAt(createAt)
            .disabledAt(disabledAt)
            .member(member.toModel())
            .build();
    }
}
