package com.parkhuiwo0.chat.domain;

import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = -3131613123536187212L;
    private String roomId;
    private String name;
//    private Set<WebSocketSession> sessions = new HashSet<>(); // pub/sub의 경우 구독자 관리가 알아서 되기 때문에

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;

        return chatRoom;
    }

//    @Builder
//    public ChatRoom(String roomId, String name) {
//        this.roomId = roomId;
//        this.name = name;
//    }

//    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
////        if (chatMessage.getType().equals(MessageType.ENTER)) {
//        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
//            sessions.add(session);
//            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
//        }
//        sendMessage(chatMessage, chatService);
//    }
//
//    public <T> void sendMessage(T message, ChatService chatService) {
//        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
//    }
}