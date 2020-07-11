/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.middlewares;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author tesa
 */
@Configuration
public class AuthMiddlewareConfiguration extends WebMvcConfigurerAdapter
{
    @Bean
    public AuthMiddleware authMiddleware() 
    {
        return new AuthMiddleware();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(this.authMiddleware()).addPathPatterns("/api/v1/**");
    }
}
