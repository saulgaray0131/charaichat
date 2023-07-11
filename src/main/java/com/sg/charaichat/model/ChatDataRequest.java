package com.sg.charaichat.model;


public class ChatDataRequest {
    private User user;
    private Integer chatId;

    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Integer getChatId() {
        return chatId;
    }
    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    
}