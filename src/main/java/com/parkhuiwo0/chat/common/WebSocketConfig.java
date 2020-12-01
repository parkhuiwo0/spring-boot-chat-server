package com.parkhuiwo0.chat.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final WebSocketChatHandler webSocketChatHandler;

//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        // setAllowedOrigins -> CORS 이슈 해결
//        registry.addHandler(webSocketChatHandler, "/ws/chat").setAllowedOrigins("*");
//    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("*")
                .withSockJS();
    }
}
