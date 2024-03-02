package com.study.chat.domain.member.controller.response;

import com.study.chat.domain.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoResponse {
    private Long id;
    private String name;
    private String nickname;
    private String token;

    public static MemberInfoResponse from(final Member member,
                                          final String token){
        return MemberInfoResponse.builder()
            .id(member.getId())
            .name(member.getName())
            .nickname(member.getNickname())
            .token(token)
            .build();
    }
}
