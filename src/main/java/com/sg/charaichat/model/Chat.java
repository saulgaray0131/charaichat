package com.sg.charaichat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Table("CHATS")
public class Chat {
    
    @Id
    private Integer id;

    @NotNull
    private Integer aiuserId;
    @NotNull
    private Integer userId;
    @NotEmpty
    private String lastChat;

    

    public Chat(@NotNull Integer aiuserId) {
        this.aiuserId = aiuserId;
    }

    public Chat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAiuserId() {
        return aiuserId;
    }

    public void setAiuserId(Integer aiuserId) {
        this.aiuserId = aiuserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastChat() {
        return lastChat;
    }

    public void setLastChat(String lastChat) {
        this.lastChat = lastChat;
    }
    
    

}
