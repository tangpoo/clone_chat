package com.study.chat.domain.member.infrastructure.entity;

import com.study.chat.domain.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

@Getter
@Entity
@Builder
@Table(name = "members")
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    public static MemberEntity fromModel(final Member member){
        return MemberEntity.builder()
            .id(member.getId())
            .name(member.getName())
            .nickname(member.getNickname())
            .build();
    }

    public Member toModel(){
        return Member.builder()
            .id(id)
            .name(name)
            .nickname(nickname)
            .build();
    }
}
