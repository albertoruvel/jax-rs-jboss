/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jax.samples.util;

import com.jax.samples.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MACARENA
 */
public class BooksFactory {
    public static final List<Book> BOOKS; 
    
    static{
        BOOKS = new ArrayList<Book>(); 
        for (int i = 0; i < 10; i++) {
            BOOKS.add(new Book("Title" + i, "Author" + i)); 
        }
    }
    
    
    
}
