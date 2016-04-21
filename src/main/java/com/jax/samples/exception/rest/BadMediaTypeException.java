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
public class BadMediaTypeException {
    
    private String status; 
    private String errorMessage; 

    public BadMediaTypeException() {
    }

    public BadMediaTypeException(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
    
}
