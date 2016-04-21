/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.app;

import com.jax.samples.resource.LibraryResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author MACARENA
 */
@ApplicationPath("/v1")
public class LibraryConfig extends Application{

    private Set<Class<?>> classes = new HashSet<Class<?>>(); 
    private Set<Object> singletons = new HashSet<Object>(); 
    
    public LibraryConfig() {
        singletons.add(new LibraryResource()); 
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes; 
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons; 
    }
    
}
