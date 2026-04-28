/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
import java.util.ArrayList;

public class Author extends Person{
    private int totalBooksInLibrary;
    private ArrayList<Book> bookList;
    
    
    //===| Constructor
    public Author(String name, String lastName){
        super(name, lastName);
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
}
