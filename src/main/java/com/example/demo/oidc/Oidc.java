/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.oidc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author tesa
 */
@RestController
public class Oidc
{
    /**
     * Oidc service.
     */
    @Autowired
    protected OidcService service;
    
    /**
     * Class controller.
     */
    public Oidc()
    {
        //
    }
    
    /**
     * Redirect to the authentication server.
     * 
     * @return RedirectView
     */
    @GetMapping("/redirect")
    public RedirectView redirect()
    {
        return this.service.redirect();
    } 
    
    /**
     * Callback to get the authentication token.
     * 
     * @param code
     * 
     * @return String
     */
    @GetMapping("/callback")
    public String callback(@RequestParam String code)
    {
        return this.service.callback(code);
    }
    
    /**
     * Check the token.
     * 
     * @return void
     */
    @GetMapping("/check")
    public void check()
    {
        // not implemented
    }
    
    /**
     * Refresh the authentication token.
     * 
     * @return String
     */
    @GetMapping("/refresh")
    public String refresh()
    {
        return this.service.refresh();
    }
    
    /**
     * End session, logout.
     * 
     * @return RedirectView
     */
    @GetMapping("/endSession")
    public RedirectView endSession()
    {
        return this.service.endSession();
    }
}
