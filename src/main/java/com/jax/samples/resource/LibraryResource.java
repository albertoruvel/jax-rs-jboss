/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.resource;

import com.jax.samples.exception.rest.BadMediaTypeException;
import com.jax.samples.exception.rest.NotFoundException;
import com.jax.samples.model.Book;
import com.jax.samples.util.BooksFactory;
import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author MACARENA
 */
@Path("/library")
public class LibraryResource {
    
    @Resource
    private WebServiceContext cxt; 
    
    @Path("/get")
    @GET
    @Produces("application/json")
    public Response getBook(@QueryParam(value="name")String bookTitle){
        System.out.println("Got GET request with queryParam: " + bookTitle);
        for (Book book : BooksFactory.BOOKS) {
            if(book.getTitle().equalsIgnoreCase(bookTitle)){
                System.out.println(book.toString());
                return Response.ok(book).build();
            }
                
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new NotFoundException("Book not found", "ASDFG123"))
                .build(); 
    }
    
    @Path("/getByType")
    @GET
    public Response getByMediaType(@QueryParam(value="mediaType")String mediaType){
        if(! mediaType.equalsIgnoreCase("application/json") && !mediaType.equalsIgnoreCase("application/xml"))
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(new BadMediaTypeException("Bad Request", "No Content-Type found to represent response: " + mediaType))
                    .build(); 
        
        return Response.ok(BooksFactory.BOOKS)
                .type(mediaType)
                .build(); 
    }
}
