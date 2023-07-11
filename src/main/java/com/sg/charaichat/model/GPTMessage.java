package com.sg.charaichat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GPTMessage {

    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;

    
    
    public GPTMessage() {
    }

    public GPTMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }
    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
