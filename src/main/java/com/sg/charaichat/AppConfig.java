package com.sg.charaichat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:app.config")
public class AppConfig {
    @Value("${apiKey}")
    private String apiKey;

    @Value("${masterApiKey}")
    private String masterApiKey;


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getMasterApiKey() {
        return masterApiKey;
    }

    public void setMasterApiKey(String masterApiKey) {
        this.masterApiKey = masterApiKey;
    }

    

    
}
