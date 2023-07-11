package com.sg.charaichat.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sg.charaichat.model.AIUser;
import com.sg.charaichat.model.Chat;
import com.sg.charaichat.model.ChatDataRequest;
import com.sg.charaichat.model.ChatDataResponse;
import com.sg.charaichat.model.ChatLine;
import com.sg.charaichat.model.ChatRequest;
import com.sg.charaichat.model.CreateChatRequest;
import com.sg.charaichat.model.EditUsernameRequest;
import com.sg.charaichat.model.GetUserRequest;
import com.sg.charaichat.model.User;
import com.sg.charaichat.repository.AiUserRepository;
import com.sg.charaichat.repository.ChatLineRepository;
import com.sg.charaichat.repository.ChatRepository;
import com.sg.charaichat.repository.UserRepository;
import com.sg.charaichat.service.ChatService;

import jakarta.security.auth.message.AuthException;
import jakarta.validation.constraints.NotNull;

@RestController
public class ApiController {

    @Autowired
    private AiUserRepository aiUserRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatLineRepository chatLineRepository;
    @Autowired
    private ChatService chatService;

    //Master API_KEY
    private final String M_KEY = "";

    @GetMapping("/api/bots")
    public Iterable<AIUser> getAiUsers() {
        return aiUserRepository.findAll();
    }

    @PostMapping("/api/create/bot")
    public AIUser createBot(@RequestHeader HttpHeaders headers, @NotNull @RequestBody AIUser aiUser) throws AuthException {
        if(headers.get("auth").get(0) != M_KEY)
            throw new AuthException("Bad Auth");

        aiUser.setUrl("placeholder.png");
        return aiUserRepository.save(aiUser);
    }

    @GetMapping("/api/bot/{id}")
    public Optional<AIUser> getAiUser(@NotNull @PathVariable Integer id) {
        return aiUserRepository.findById(id);
    }

    @PostMapping("/api/create/user")
    public User createUser(@NotNull @RequestBody User request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setUrl("placeholder");
        newUser.setUuid(UUID.randomUUID().toString());
        return userRepository.save(newUser);
    }

    @PostMapping("/api/chats")
    public Iterable<Chat> getUserChats(@NotNull @RequestBody User request) throws AuthException{
        User user = userRepository.findById(request.getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUuid()))
            throw new AuthException("Auth error!");

        return chatRepository.findByUserId(user.getId());
    }

    @PostMapping("/api/create/chat")
    public Chat createChat(@NotNull @RequestBody CreateChatRequest request) throws AuthException {

        Chat newChat = new Chat();

        User user = userRepository.findById(request.getUser().getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUser().getUuid())) {
            throw new AuthException("Auth error!");
        }

        newChat.setAiuserId(request.getAiId());
        newChat.setUserId(request.getUser().getId());
        newChat.setLastChat("Click here to start chatting!");

        return chatRepository.save(newChat);
    }

    @PostMapping("/api/chatdata")
    public ChatDataResponse getChatData(@NotNull @RequestBody ChatDataRequest request) throws Exception {

        User user = userRepository.findById(request.getUser().getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUser().getUuid())) {
            throw new AuthException("Auth error!");
        }

        ChatDataResponse chatData = new ChatDataResponse();
        chatData.setChat(chatRepository.findById(request.getChatId()).orElseThrow());
        chatData.setAiUser(aiUserRepository.findById(chatData.getChat().getAiuserId()).orElseThrow());
        chatData.setLines(chatLineRepository.findByChatIdOrderByCreatedAtAsc(chatData.getChat().getId()));

        return chatData;
    }

    @PostMapping("/api/chat")
    public List<ChatLine> chat(@NotNull @RequestBody ChatRequest request) throws Exception {
        User user = userRepository.findById(request.getUser().getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUser().getUuid())) { //Proper auth
            throw new AuthException("Auth error!");
        }

        ChatLine chatResponse = new ChatLine();
        chatResponse.setCreatedAt(new Timestamp(new Date().getTime()));
        chatResponse.setChatId(request.getLine().getChatId());
        chatResponse.setText(request.getLine().getText());
        chatResponse.setUserId(user.getId());
        

        return Arrays.asList(chatResponse, chatService.chat(chatResponse));
    }

    @PostMapping("/api/account/edit/username")
    public User editUsername(@NotNull @RequestBody EditUsernameRequest request) throws Exception {
        User user = userRepository.findById(request.getUser().getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUser().getUuid())) { //Proper auth
            throw new AuthException("Auth error!");
        }

        user.setUsername(request.getUsername());

        return userRepository.save(user);
    }

    @PostMapping("/api/account/data")
    public User getUser(@NotNull @RequestBody GetUserRequest request) throws Exception {
        User user = userRepository.findById(request.getUser().getId()).orElseThrow();
        if(!user.getUuid().equalsIgnoreCase(request.getUser().getUuid())) { //Proper auth
            throw new AuthException("Auth error!");
        }

        return user;
    }
}
