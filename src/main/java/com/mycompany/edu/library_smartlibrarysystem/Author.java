/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
import java.util.*;

public class Author extends Person{
    private int totalBooksInLibrary;
    private List<Book> bookList = new ArrayList<>();
    
    private static List<Author> allAuthors = new ArrayList<>();
    
    
    //===| Constructor
    public Author(String firstName, String lastName){
        super(firstName, lastName);
        allAuthors.add(this);
    }
    
    //==| Getters and setters    
    //---> Book related
    public int getTotalBooksInLibrary(){
        return totalBooksInLibrary;
    }
    
    public void setTotalBooksInLibrary(int total){
        this.totalBooksInLibrary = total;
    }
    public void addBook(String name, Cover cover, Category category, int totalPages, double value, int quantity){
        bookList.add(new Book(name, cover, category, totalPages, value, quantity, this));
        
    }
    
    public static Author lookup(String firstName, String lastName){
        for (Author author : allAuthors){
            if (author.firstName.equals(firstName) && author.lastName.equals(lastName)){
                return author;
            }
            
        }
        return null;
    } 
}
