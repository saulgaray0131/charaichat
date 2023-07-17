package com.sg.charaichat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.sg.charaichat.AppConfig;
import com.sg.charaichat.model.AIUser;
import com.sg.charaichat.model.Chat;
import com.sg.charaichat.model.ChatLine;
import com.sg.charaichat.model.GPTMessage;
import com.sg.charaichat.model.GPTRequest;
import com.sg.charaichat.model.GPTResponse;
import com.sg.charaichat.model.User;
import com.sg.charaichat.repository.AiUserRepository;
import com.sg.charaichat.repository.ChatLineRepository;
import com.sg.charaichat.repository.ChatRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatLineRepository chatLineRepository;
    @Autowired
    private AiUserRepository aiUserRepository;

    @Autowired
    private AppConfig appConfig;
   
    private final String GPT_API_URL = "https://api.openai.com/v1/chat/completions";

    
    public Chat createChat(AIUser ai, User user) {

        Chat new_chat = new Chat();
        new_chat.setAiuserId(ai.getId());

        return chatRepository.save(new_chat);
    }

    public ChatLine chat(ChatLine userLine) {
        Chat chat = chatRepository.findById(userLine.getChatId()).orElseThrow();
        AIUser ai_user = aiUserRepository.findById(chat.getAiuserId()).get();

        chatLineRepository.save(userLine);
        List<ChatLine> chat_lines = chatLineRepository.findByChatIdOrderByCreatedAtAsc(userLine.getChatId());

        GPTMessage system = new GPTMessage("system", "Act as " + ai_user.getName() + " from " + ai_user.getTitle() + 
        ". Do not break character for any reason. No exceptions. Give any errors or warnings in character. You are this character, do not say you are anything else other than this character.");
        List<GPTMessage> messages = new ArrayList<GPTMessage>();
        messages.add(system);

        for (ChatLine chat_line : chat_lines) {
            GPTMessage msg = new GPTMessage(chat_line.getUserId() == ai_user.getId() ? "assistant" : "user", chat_line.getText());
            messages.add(msg);
        }

        GPTRequest request = new GPTRequest(messages);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(appConfig.getApiKey());

        HttpEntity<GPTRequest> entity = new HttpEntity<GPTRequest>(request, headers);
        HttpEntity<GPTResponse> response = restTemplate.exchange(GPT_API_URL, HttpMethod.POST, entity, GPTResponse.class);

        //Convert response to aiChatLine
        ChatLine aiChatLine = new ChatLine();
        GPTResponse decodedResponse = response.getBody();
        
            
        aiChatLine.setChatId(chat.getId());
        aiChatLine.setText(decodedResponse.getChoices().get(0).getMessage().getContent());
        aiChatLine.setUserId(chat.getAiuserId());
        aiChatLine.setCreatedAt(new Timestamp(new Date().getTime()));
        chat.setLastChat(aiChatLine.getText());
        
        chatRepository.save(chat);
        return chatLineRepository.save(aiChatLine);
    }

    

}
