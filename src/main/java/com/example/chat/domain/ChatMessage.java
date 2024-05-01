package com.example.chat.domain;

import lombok.Data;

@Data
public class ChatMessage {
    private String userFrom;
    private String userTo;
    private String message;
}