package com.parkhuiwo0.chat.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkhuiwo0.chat.service.ChatService;
import com.parkhuiwo0.chat.domain.ChatMessage;
import com.parkhuiwo0.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        super.handleTextMessage(session, message);
        String payload = message.getPayload();
        log.info("payload = " + payload);
//        TextMessage textMessage = new TextMessage("채팅 애플리케이션에 오신 것을 환영합니다.");
//        session.sendMessage(textMessage);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatMessage chatMessage = objectMapper
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());

        room.handleActions(session, chatMessage, chatService);
    }
}
