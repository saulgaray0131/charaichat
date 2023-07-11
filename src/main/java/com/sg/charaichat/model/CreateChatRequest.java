package com.sg.charaichat.model;

public class CreateChatRequest {

    private Integer aiId;
    private User user;

    
    public Integer getAiId() {
        return aiId;
    }
    public void setAiId(Integer aiId) {
        this.aiId = aiId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
