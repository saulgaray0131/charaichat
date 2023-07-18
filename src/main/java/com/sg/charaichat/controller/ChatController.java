package com.sg.charaichat.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sg.charaichat.model.Chat;
import com.sg.charaichat.model.ChatLine;
import com.sg.charaichat.model.CreateChatRequest;
import com.sg.charaichat.model.User;
import com.sg.charaichat.service.ChatService;
import com.sg.charaichat.service.UserService;
import jakarta.validation.constraints.NotNull;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired 
    private UserService userService;


}
