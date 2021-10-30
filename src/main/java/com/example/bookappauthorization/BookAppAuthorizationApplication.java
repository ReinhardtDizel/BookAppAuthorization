package com.example.bookappauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BookAppAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAppAuthorizationApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/books").allowedOrigins("http://localhost:8080");
                registry.addMapping("/books").allowedOrigins("http://localhost:3000");
                registry.addMapping("/authors").allowedOrigins("http://localhost:8080");
                registry.addMapping("/authors").allowedOrigins("http://localhost:3000");
                registry.addMapping("/registration").allowedOrigins("http://localhost:8080");
                registry.addMapping("/registration").allowedOrigins("http://localhost:3000");
                registry.addMapping("/*/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE");
                registry.addMapping("/**");

            }
        };
    }
}
