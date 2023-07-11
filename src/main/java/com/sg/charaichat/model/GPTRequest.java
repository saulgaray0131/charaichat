package com.sg.charaichat.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GPTRequest {

    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<GPTMessage> messages;


    public GPTRequest(List<GPTMessage> messages) {
        this.model = "gpt-3.5-turbo";
        this.messages = messages;
    }
}
