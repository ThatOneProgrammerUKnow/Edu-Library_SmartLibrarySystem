/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
import java.time.LocalDate;
import java.util.ArrayList;
 
class BorrowedBook {
    private final int id;
    private Member member;
    private Book book;
    private LocalDate dateBorrowed;
    private LocalDate renewalDate;
    private Boolean returned;

    static private int totalObjects = 0;
    
    //===| Constructor
    public BorrowedBook(Member member, Book book) {
        this.id = totalObjects; 
        this.member = member;
        this.book = book;
        this.dateBorrowed = LocalDate.now();
        this.renewalDate = dateBorrowed.plusDays(14);
        this.returned = false;
        
        
        totalObjects++;
    }
 
    //===| Getters and setters
    public Member getMember() {
        return member;
    }
    public Book getBook() {
        return book;
    }
 
    public LocalDate getDateBorrowed() {
        return this.dateBorrowed;
    }
    
    public LocalDate getRenewalDate() {
        return this.renewalDate;
    }
    
}
