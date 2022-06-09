package com.newrev.p1.config;

import com.newrev.p1.model.Product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//   @Scope(value = "prototype")
    @Bean
    public Product product() {
        return new Product();
    }
/*
    @Bean
    public PasswordHashing getPasswordHashing(){
        return new PasswordHashing();
    }*/
}
