package com.parkhuiwo0.chat.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {

    public enum MessageType {
        TALK, ENTER
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

}
