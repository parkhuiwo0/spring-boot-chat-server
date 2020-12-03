package com.parkhuiwo0.chat.controller;

import com.parkhuiwo0.chat.common.RedisPublisher;
import com.parkhuiwo0.chat.domain.ChatMessage;
import com.parkhuiwo0.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class ChatController {
//
////    private final ChatService chatService;
//
//    private final SimpMessageSendingOperations messagingTemplate;
//
//    @MessageMapping("/chat/message")
//    public void message(ChatMessage message) {
//        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
//            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
//        }
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//    }
@RequiredArgsConstructor
@Controller
public class ChatController {

//    private final SimpMessageSendingOperations messagingTemplate;

    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * Websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId(), message));
    }
}

//    @PostMapping
//    public ChatRoom createRoom(@RequestParam("name") String name) {
//        return chatService.createRoom(name);
//    }
//
//    @GetMapping
//    public List<ChatRoom> findAllRoom() {
//        return chatService.findAllRoom();
//    }

