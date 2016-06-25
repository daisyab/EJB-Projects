/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ublab.stateful;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author daisy
 */
@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {
    
    List<String> bookShelf;
    
    public LibraryStatefulSessionBean(){
        bookShelf = new ArrayList<String>();
    }

    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }
    
    public List<String> getBooks() {
        return bookShelf;
    }
}