package com.study.chat.domain.common.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.chat.domain.common.service.port.RedisSubscribe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisSubscriberImpl implements RedisSubscribe {

    private final ObjectMapper om;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void sendMessage(String publishMessage) {

    }

    @Override
    public void sendChatRoomInfo(String publishMessage) {

    }

    @Override
    public void sendMessageToMember(String publishMessage) {

    }
}
