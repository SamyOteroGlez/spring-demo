/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.middlewares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author tesa
 */
public class AuthMiddleware extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception
    {
        String header = request.getHeader("Authorization");
        
        // Check for the bearer token
        if (null == header) {
            // Redirect to the authentication server
            response.sendRedirect("/redirect");
            
            return false;
        }
        
        return true;
    }
}
