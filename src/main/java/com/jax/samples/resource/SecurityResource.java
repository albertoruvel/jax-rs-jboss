/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.resource;

import com.jax.samples.dto.UserCredentials;
import com.jax.samples.exception.rest.AuthenticationException;
import com.jax.samples.security.AuthenticationManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author MACARENA
 */
@Path("/security")
public class SecurityResource {
    
    @Inject
    private AuthenticationManager manager; 

    public SecurityResource() {
    }
    
    
    
    @Path("/auth")
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticateUser(UserCredentials creds){
        if(creds != null)
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new AuthenticationException(new Date().toString(), 
                            UUID.randomUUID().toString(), "No credentials found"))
                    .build(); 
        return null; 
    }
}
