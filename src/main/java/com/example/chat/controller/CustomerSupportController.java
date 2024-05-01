package com.example.chat.controller;

import com.example.chat.domain.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerSupportController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    public void processMessage(@Payload ChatMessage message) {
        simpMessagingTemplate.convertAndSendToUser(message.getUserTo(), "/user/queue/recipient", message);
    }
}
