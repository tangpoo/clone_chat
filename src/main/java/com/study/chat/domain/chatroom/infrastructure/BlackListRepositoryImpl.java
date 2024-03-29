package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.controller.domain.ChatRoom;
import com.study.chat.domain.chatroom.domain.BlackList;
import com.study.chat.domain.chatroom.infrastructure.entity.BlackListEntity;
import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.chatroom.service.port.BlackListRepository;
import com.study.chat.domain.member.domain.Member;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BlackListRepositoryImpl implements BlackListRepository {

    private final BlackListJpaRepository blackListJpaRepository;

    @Override
    public BlackList save(BlackList blackList) {
        return blackListJpaRepository.save(BlackListEntity.fromModel(blackList)).toModel();
    }

    @Override
    public Optional<BlackList> findByRoomAndMember(ChatRoom room, Member member) {
        return blackListJpaRepository
            .findByRoomAndMember(ChatRoomEntity.fromModel(room), MemberEntity.fromModel(member))
            .map(BlackListEntity::toModel);
    }
}
