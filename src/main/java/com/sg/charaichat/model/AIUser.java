package com.sg.charaichat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;

@Table("AIUSERS")
public class AIUser {

    @Id
    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String systemDsc;
    @NotBlank 
    private String description;
    @NotBlank String url;

    
    public AIUser(@NotBlank String name, @NotBlank String systemDsc) {
        this.name = name;
        this.systemDsc = systemDsc;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSystemDsc() {
        return systemDsc;
    }
    public void setSystemDsc(String systemDsc) {
        this.systemDsc = systemDsc;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    

}
