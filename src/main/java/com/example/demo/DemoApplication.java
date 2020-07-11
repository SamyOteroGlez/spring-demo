package com.example.demo;

import com.example.demo.oidc.OidcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "com.example.demo.*",
    "com.example.demo.oidc.*",
    "com.example.demo.services.*",
    "com.example.demo.repositories.*",
    "com.example.demo.entities.*",
})
public class DemoApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    OidcService oidcService() 
    {
        return new OidcService();
    }
}
