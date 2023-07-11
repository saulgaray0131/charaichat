package com.sg.charaichat.model;

public class GPTChoices {
    private Integer index;
    private GPTMessage message;
    private String finish_reason;

    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public GPTMessage getMessage() {
        return message;
    }
    public void setMessage(GPTMessage message) {
        this.message = message;
    }
    public String getFinish_reason() {
        return finish_reason;
    }
    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
    
    

    
}
