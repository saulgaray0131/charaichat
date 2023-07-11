package com.sg.charaichat.model;

public class EditUsernameRequest {
    private User user;
    private String username;
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
