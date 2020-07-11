/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.oidc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author tesa
 */
public class OidcService
{
    @Value("${oidc.on}")
    protected String status;
    
    @Value("${oidc.keycloak.clientId}")
    protected String clientId;
    
    @Value("${oidc.keycloak.clientSecret}")
    protected String clientSecret;
    
    @Value("${oidc.keycloak.scope}")
    protected String scope;
    
    @Value("${oidc.keycloak.grantType}")
    protected String grantType;
    
    @Value("${oidc.keycloak.redirectUri}")
    protected String redirectUri;
    
    @Value("${oidc.keycloak.authUri}")
    protected String authUri;
    
    @Value("${oidc.keycloak.tokenUri}")
    protected String tokenUri;
    
    @Value("${oidc.keycloak.userInfoUri}")
    protected String userInfoUri;
    
    @Value("${oidc.keycloak.endsession}")
    protected String endSession;
    
    /**
     * Class constructor.
     */
    public OidcService() 
    {
        //
    }
    
    /**
     * Get oidc status.
     * 
     * @return Boolean
     */
    public Boolean status()
    {
        return ("true" == this.status);
    }
    
    /**
     * Redirect endpoint.
     * 
     * @return RedirectView
     */
    public RedirectView redirect()
    {
        String url = this.authUri 
                        + "?client_id=" + this.clientId 
                        + "&redirect_uri=" + this.redirectUri 
                        + "&response_type=code" 
                        + "&scope=" + this.scope;
        
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        
        return redirectView;
    } 
    
    /**
     * Callback, get the authentication token.
     * 
     * @param code
     * 
     * @return String
     */
    public String callback(String code)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap <String, String> formParams = new LinkedMultiValueMap <> ();
        
        formParams.add("grant_type", this.grantType);
        formParams.add("client_id", this.clientId);
        formParams.add("client_secret", this.clientSecret);
        formParams.add("redirect_uri", this.redirectUri);
        formParams.add("scope", this.scope);
        formParams.add("code", code);
        
        HttpEntity <?> request = new HttpEntity <> (formParams, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <String> response = restTemplate.postForEntity(this.tokenUri, request, String.class);
        
        return response.getBody();
    }
    
    /**
     * Check for the token validity.
     * 
     * @param bearer
     * 
     * @return boolean
     */
    public boolean check(String bearer)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", bearer);        
        HttpEntity request = new HttpEntity(headers);        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <String> response = restTemplate.exchange(this.userInfoUri, HttpMethod.GET,  request, String.class);
        
        return (response.getStatusCode() == HttpStatus.OK);
    }
    
    /**
     * Refresh the token.
     * 
     * @return String
     */
    public String refresh()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap <String, String> formParams = new LinkedMultiValueMap <> ();
        
        formParams.add("grant_type", "refresh_token");
        formParams.add("client_id", this.clientId);
        formParams.add("client_secret", this.clientSecret);
        formParams.add("refresh_token", "the-refresh-token");
        formParams.add("scope", this.scope);
        
        HttpEntity <?> request = new HttpEntity <> (formParams, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <String> response = restTemplate.postForEntity(this.tokenUri, request, String.class);
        
        return response.getBody();
    }
    
    /**
     * End session, logout.
     * 
     * @return RedirectView
     */
    public RedirectView endSession()
    {
        String url = this.endSession + "?redirect_uri=" + this.redirectUri;
        
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        
        return redirectView;
    }
}
