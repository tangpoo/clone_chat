package com.study.chat.domain.chatroom.infrastructure;

import com.study.chat.domain.chatroom.infrastructure.entity.ChatRoomEntity;
import com.study.chat.domain.member.infrastructure.entity.MemberEntity;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRoomJpaRepository extends JpaRepository<ChatRoomEntity, Long> {
    @Query("SELECT c FROM ChatRoomEntity  c " +
           "WHERE c.id NOT IN (SELECT b.room.id FROM BlackListEntity b WHERE b.member = :member)")
    List<ChatRoomEntity> findRoomsNotInBlacklistForMemberEntity(@Param("member")MemberEntity member);
}
