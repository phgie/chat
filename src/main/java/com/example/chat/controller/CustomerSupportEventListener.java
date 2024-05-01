package com.example.chat.controller;

import com.example.chat.domain.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
@Slf4j
public class CustomerSupportEventListener {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        log.info("New connection established!");

        val user = event.getUser().getName();
        val message = new ChatMessage();
        message.setUserFrom(user);
        message.setMessage("User " + user + " needs support.");

        messagingTemplate.convertAndSend("/topic/support", message);
    }
}
