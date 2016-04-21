/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.exception.rest;

import javax.xml.ws.http.HTTPException;

/**
 *
 * @author MACARENA
 */
public class NotFoundException{
    
    private String errorMessage; 
    private String appCode; 

    public NotFoundException(String message, String appCode) {
        this.errorMessage = message;
        this.appCode = appCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
    
    
    
    
}
