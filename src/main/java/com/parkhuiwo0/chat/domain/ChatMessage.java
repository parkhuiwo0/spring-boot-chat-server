package com.parkhuiwo0.chat.domain;

import lombok.Getter;

@Getter
public class ChatMessage {

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;

}
