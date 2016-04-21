/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.exception.rest;

/**
 *
 * @author MACARENA
 */
public class AuthenticationException {
    private String date; 
    private String requestId; 
    private String message; 

    public AuthenticationException() {
    }

    public AuthenticationException(String date, String requestId, String message) {
        this.date = date;
        this.requestId = requestId;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
