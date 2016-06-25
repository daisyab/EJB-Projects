/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ublab.stateless;

import com.ublab.entity.Books;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author daisy
 */

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {
    
    public LibraryPersistentBean(){
            
    }
    
    @PersistenceContext(unitName="EjbComponent3PU")
    private EntityManager entityManager;
    
    public void addBook(Books book) {
        
        entityManager.persist(book);
    
    }
    
    public List<Books> getBooks() {
        
        Query q2 = entityManager.createQuery("SELECT b FROM Books b");

        return q2.getResultList();
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct:: LibraryPersistentBean session bean"
                + " created with entity Manager object: ");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy: LibraryPersistentBean session"
                + " bean is removed ");
    }
}
