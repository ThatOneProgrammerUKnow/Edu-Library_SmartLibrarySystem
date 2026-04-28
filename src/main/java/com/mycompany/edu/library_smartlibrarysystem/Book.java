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

public class Book implements IncreaseMoney, SetMoney{
    private int id;
    
    final private String name;
    final private Cover cover;
    final private Category category;
    final private int totalPages;
    private double value;
    private int quantity;
    private int available; 
    final private Author author;
    
    // Static
    private static List<Book> allBooks = new ArrayList<>();
    private static List<Book> availableBooks = new ArrayList<>();
    static int totalObjects = 0;
    
    //===| Constructor
    public Book(String name, Cover cover, Category category, int totalPages, double value, int quantity, Author author){
        // Exception handling
        if (quantity <0){
            throw new IllegalArgumentException("There can not be a negative quantity of this book; please enter a valid quantity");
        } 
      
        // Book name and details
        this.name = name;
        this.cover = cover;
        this.category = category;
        this.totalPages = totalPages;
        this.value = value;
        this.quantity = quantity;
        this.available = quantity;
        this.id = totalObjects;
        this.author = author;
        
        // Static
        totalObjects++;
        
        allBooks.add(this);
        
    }
    //===| Overrides
    @Override
    public void increaseMoney(double amount){
        this.value += amount;
    }
    
    @Override
    public void setMoney(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("The book cannot have a negative value; please enter a valid amount");
        }
    }
    
    //===| Other logic
    //---> Borrowing and returning a book
    public void borrowBook(){
        // Exception handling
        if (this.available < 1){
            throw new IllegalArgumentException("No more available books");
        }
        
        // Actual borrow logic
        this.available--;
    }
    
    public void returnBook(){
        // Exception handling can be done so the available books does not exceed the quantity
        this.available++;
    }
    
    //---> Lookup
    public Book lookUp(String bookName, String authorName){
        for (Book book : this.allBooks){
            // If a book is found that matches the lookup parametres
            if (book.name.equals(bookName) && book.author.getFirstName().equals(authorName)){
                return book;
            }
        }
        // If the book was not found
        return null;
    }
    
    //===| Getters and setters
    public String getName(){
        return this.name;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public int getAvailability(){
        return this.available;
    }
    
    public static List<Book> getBooks(){
        return allBooks;
    }
}
