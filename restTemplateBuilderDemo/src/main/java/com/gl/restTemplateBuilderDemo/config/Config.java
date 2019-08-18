package com.gl.restTemplateBuilderDemo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .setReadTimeout(Duration.ofMillis(1000))
                .build();
    }




















    /*
    @Bean
    public MyRequestInterceptor myRequestInterceptor(){
        return new MyRequestInterceptor();
    }

    @Bean
    public MyRestTemplateCustomizer restTemplateCustomizer(){
        return new MyRestTemplateCustomizer();
    }

    @Bean
    @DependsOn("restTemplateCustomizer")
    public RestTemplateBuilder restTemplateBuilder(){
        return new RestTemplateBuilder(restTemplateCustomizer());
    }*/
}
