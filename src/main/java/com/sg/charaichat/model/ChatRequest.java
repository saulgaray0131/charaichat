package com.sg.charaichat.model;

public class ChatRequest {
    private User user;
    private ChatLine line;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ChatLine getLine() {
        return line;
    }
    public void setLine(ChatLine line) {
        this.line = line;
    }

    
}
