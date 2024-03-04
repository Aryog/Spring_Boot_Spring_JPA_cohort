package com.aryog.firstapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
    @Bean
//    @Profile("test")
    public MyFirstClass myFirstBean(){
        return new MyFirstClass("First Bean");
    }
    @Bean
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("Second Bean");
    }
    @Bean
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("Third Bean");
    }
}
