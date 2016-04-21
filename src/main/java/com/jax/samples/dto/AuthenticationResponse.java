/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.dto;

/**
 *
 * @author MACARENA
 */
public class AuthenticationResponse {
    private String token; 
    private String date; 
    private String expiration; 
    private String status;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, String date, String expiration, String status) {
        this.token = token;
        this.date = date;
        this.expiration = expiration;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
