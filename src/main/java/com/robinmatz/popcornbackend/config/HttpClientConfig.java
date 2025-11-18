package com.robinmatz.popcornbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@ConfigurationProperties(prefix = "app.movie-client")
public class HttpClientConfig {

    private String apiKey;

    @Bean
    public RestClient restClient() {
        return RestClient.create("http://www.omdbapi.com");
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
