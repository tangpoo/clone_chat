package com.study.chat.domain.chatroom.infrastructure.entity;

import com.study.chat.domain.chatroom.domain.ParticipationRoom;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participation_room")
public class ParticipationRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "room")
    private ChatRoomEntity room;

    @Column(name = "submit_key")
    private Boolean submitKey = false;

    @Column(name = "joined")
    private Boolean joined = false;


    public static ParticipationRoomEntity from(ParticipationRoom participationRoom){
        return ParticipationRoomEntity.builder()
            .id(participationRoom.getId())
            .member(MemberEntity.fromModel(participationRoom.getMember()))
            .room(ChatRoomEntity.fromModel(participationRoom.getChatRoom()))
            .submitKey(participationRoom.getSubmitKey())
            .joined(participationRoom.getJoined())
            .build();
    }

    public ParticipationRoom toModel(){
        return ParticipationRoom.builder()
            .id(id)
            .member(member.toModel())
            .chatRoom(room.toModel())
            .submitKey(submitKey)
            .joined(joined)
            .build();
    }
}
