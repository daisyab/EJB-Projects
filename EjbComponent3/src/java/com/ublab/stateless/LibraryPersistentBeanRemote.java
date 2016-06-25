/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ublab.stateless;

import javax.ejb.Remote;
import com.ublab.entity.Books;
import java.util.List;

/**
 *
 * @author daisy
 */
@Remote
public interface LibraryPersistentBeanRemote {
    void addBook(Books bookName);

    List<Books> getBooks();

}
