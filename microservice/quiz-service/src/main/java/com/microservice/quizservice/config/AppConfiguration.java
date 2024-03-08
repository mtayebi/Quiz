package com.microservice.quizservice.config;


import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.microservice.quizservice")
public class AppConfiguration {

}
