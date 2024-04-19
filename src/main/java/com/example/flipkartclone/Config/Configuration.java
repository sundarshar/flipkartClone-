package com.example.flipkartclone.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
