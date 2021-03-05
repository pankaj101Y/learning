package com.example.learnings;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class Config {

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){

        Duration duration=Duration.ofSeconds(3000);
        return builder.setConnectTimeout(duration).build();
    }
}
