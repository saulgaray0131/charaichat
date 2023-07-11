package com.sg.charaichat.model;
import java.util.List;

public class GPTResponse {
    private String id;
    private String object;
    private Integer created;
    private List<GPTChoices> choices;
    private GPTUsage usage;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public Integer getCreated() {
        return created;
    }
    public void setCreated(Integer created) {
        this.created = created;
    }
    public List<GPTChoices> getChoices() {
        return choices;
    }
    public void setChoices(List<GPTChoices> choices) {
        this.choices = choices;
    }
    public GPTUsage getUsage() {
        return usage;
    }
    public void setUsage(GPTUsage usage) {
        this.usage = usage;
    }

    
}
