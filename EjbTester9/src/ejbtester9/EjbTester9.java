/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbtester9;

import com.ublab.entity.Book;
import com.ublab.entity.Books;
import com.ublab.entity.Publisher;
import com.ublab.stateless.LibraryPersistentBeanRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author daisy
 */
public class EjbTester9 {

    BufferedReader brConsoleReader = null;
    Properties props;
    InitialContext ctx;
    {
        props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.PROVIDER_URL, "localhost");
       
    try {
        ctx = new InitialContext(props);
    } catch (NamingException ex) {
        ex.printStackTrace();
    }
    brConsoleReader =
            new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static void main(String[] args) {
        EjbTester9 ejbTester = new EjbTester9();
        ejbTester.testEmbeddedObjects();
    }
    
    private void showGUI(){
        System.out.println("**********************");
        System.out.println("Welcome to Book Store");
        System.out.println("**********************");
        System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
    }
  
    private void testEmbeddedObjects(){
        try {
            int choice = 1;
            LibraryPersistentBeanRemote libraryBean =
                    (LibraryPersistentBeanRemote)
            ctx.lookup("LibraryPersistentBean/remote");
            
            while (choice != 2) {
                String bookName;
                
                String publisherName;
                
                String publisherAddress;
                
                showGUI();
                
                String strChoice = brConsoleReader.readLine();
                
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    
                    bookName = brConsoleReader.readLine();
                    
                    System.out.print("Enter publisher name: ");
                    
                    publisherName = brConsoleReader.readLine();
                    
                    System.out.print("Enter publisher address: ");
                    
                    publisherAddress = brConsoleReader.readLine();
                    
                    Book book = new Book();
                    
                    book.setName(bookName);
                    
                    book.setPublisher(new Publisher(publisherName,publisherAddress));
                    libraryBean.addBook(book);
                } else if (choice == 2) {
                    break;
                }
            }
            
            List<Books> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            int i = 0;
            for (Books book:booksList) {
            System.out.println((i + 1) + ".Book Name: " + book.getName() +" -> Publisher Info: "
                    + book.getPublisher());
               // System.out.println("Publication: " + book.getPublisher());
            i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        e.printStackTrace();
        }finally {
            try {
                if(brConsoleReader !=null){
                    brConsoleReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}