package com.study.chat.domain.chatroom.infrastructure.entity;

import com.study.chat.domain.chatroom.domain.BlackList;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BlackListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_room")
    private ChatRoomEntity room;

    @ManyToOne
    @JoinColumn(name = "ban_Member")
    private MemberEntity member;

    @CreatedDate
    private LocalDateTime registrationAt;

    public BlackListEntity(ChatRoomEntity room,
                           MemberEntity memberEntity){
        this.room = room;
        this.member = memberEntity;
    }

    public static BlackListEntity fromModel(BlackList blackList){
        return BlackListEntity.builder()
            .id(blackList.getId())
            .member(MemberEntity.fromModel(blackList.getMember()))
            .room(ChatRoomEntity.fromModel(blackList.getRoom()))
            .registrationAt(blackList.getRegistrationAt())
            .build();
    }

    public BlackList toModel(){
        return BlackList.builder()
            .id(id)
            .member(member.toModel())
            .room(room.toModel())
            .registrationAt(registrationAt)
            .build();
    }
}
