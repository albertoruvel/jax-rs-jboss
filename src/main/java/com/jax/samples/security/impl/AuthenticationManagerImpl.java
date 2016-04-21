/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.security.impl;

import com.jax.samples.dto.AuthenticationResponse;
import com.jax.samples.dto.UserCredentials;
import com.jax.samples.security.AuthenticationManager;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author MACARENA
 */
public class AuthenticationManagerImpl implements AuthenticationManager{
   
    @ApplicationScoped
    private static List<UserCredentials> hardcodedCredentials; 
    
    private List<AuthenticationResponse> activeTokens; 
    
    static{
        hardcodedCredentials.add(new UserCredentials("albertinio", "rubalcaba")); 
    }

    public AuthenticationManagerImpl() {
        activeTokens = new LinkedList<AuthenticationResponse>(); 
    }
    
    

    @Override
    public AuthenticationResponse authenticateUser(UserCredentials cred) {
        AuthenticationResponse response = new AuthenticationResponse(); 
        for (UserCredentials authenticatedCredential : hardcodedCredentials) {
            if(cred.getUsername().equalsIgnoreCase(authenticatedCredential.getUsername())
                    && cred.getPassword().equals(authenticatedCredential.getPassword())){
                //authenticate the user 
                Date authDate = new Date(); 
                //create a new date to 5 mins away 
                Date expires = new Date(authDate.getTime() + 3000); //adds 5 mins
                String randomToken = createNewToken(); 
                response.setToken(randomToken);
                response.setDate(authDate.toString());
                response.setExpiration(expires.toString()); //add 5 min
                response.setStatus("OK");
                if(! activeTokens.contains(response))
                    activeTokens.add(response);
                return response; 
            }
        }
        response.setDate(new Date().toString());
        response.setExpiration("N/A");
        response.setStatus("FAIL");
        response.setToken("N/A");
        return response; 
    }

    @Override
    public boolean isTokenExpired(String token) {
        for (AuthenticationResponse resp : activeTokens) {
            if(resp.getToken().equals(token)){
                //check differences of time 
                Date date = new Date(); 
                Date expiration = new Date(resp.getExpiration()); 
                if(date.getTime() < expiration.getTime())
                    return true; 
                
            }
        }
        //token not found ????
        return false; 
    }

    @Override
    public AuthenticationResponse refreshToken(String token) {
        for (AuthenticationResponse re : activeTokens) {
            if(re.getToken().equals(token)){
                String newToken = createNewToken(); 
                re.setToken(newToken);
                return re; 
            }
        }
        return null; 
    }
    
    
    /**
     * creates a dummy token
     * @return 
     */
    private String createNewToken(){
        SecureRandom sr = new SecureRandom(); 
        byte[] buff = new byte[32]; 
        sr.nextBytes(buff);
        return new String(buff);
    }
}
