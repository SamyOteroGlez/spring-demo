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
    @Autowired
    protected OidcService service;
    
    public Oidc()
    {
        //
    }
    
    @GetMapping("/redirect")
    public RedirectView redirect()
    {
        return this.service.redirect();
    } 
    
    @GetMapping("/callback")
    public String callback(@RequestParam String code)
    {
        return this.service.callback(code);
    }
    
    @GetMapping("/check")
    public void check()
    {
        //
    }
    
    @GetMapping("/refresh")
    public String refresh()
    {
        return this.service.refresh();
    }
    
    @GetMapping("/endSession")
    public RedirectView endSession()
    {
        return this.service.endSession();
    }
}
