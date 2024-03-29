package com.study.chat.global.dummymember;

import com.study.chat.domain.member.infrastructure.MemberJpaRepository;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class MemberDummyDataInit {
    private final MemberJpaRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData(){
        userRepository.save(
            MemberEntity.builder()
                .name("admin")
                .nickname("admin")
                .build()
        );

        userRepository.save(
            MemberEntity.builder()
                .name("guest")
                .nickname("guest")
                .build()
        );

        userRepository.save(
            MemberEntity.builder()
                .name("qa")
                .nickname("qa")
                .build()
        );
    }
}
