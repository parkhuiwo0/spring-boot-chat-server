package com.parkhuiwo0.chat.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        super.handleTextMessage(session, message);
        String payload = message.getPayload();
        log.info("payload = " + payload);
        TextMessage textMessage = new TextMessage("채팅 애플리케이션에 오신 것을 환영합니다.");
        session.sendMessage(textMessage);
    }
}
