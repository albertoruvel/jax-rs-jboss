/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.security;

import com.jax.samples.dto.AuthenticationResponse;
import com.jax.samples.dto.UserCredentials;

/**
 *
 * @author MACARENA
 */
public interface AuthenticationManager {
    public AuthenticationResponse authenticateUser(UserCredentials cred); 
    public boolean isTokenExpired(String token); 
    public AuthenticationResponse refreshToken(String token); 
}
