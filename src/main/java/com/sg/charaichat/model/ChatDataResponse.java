package com.sg.charaichat.model;

import java.util.List;

public class ChatDataResponse {
    private Chat chat;
    private AIUser aiUser;

    private List<ChatLine> lines;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public AIUser getAiUser() {
        return aiUser;
    }

    public void setAiUser(AIUser aiUser) {
        this.aiUser = aiUser;
    }

    public List<ChatLine> getLines() {
        return lines;
    }

    public void setLines(List<ChatLine> lines) {
        this.lines = lines;
    }

    
}
