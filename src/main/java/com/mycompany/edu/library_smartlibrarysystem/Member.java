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

public class Member extends ContactablePerson implements IncreaseMoney, DecreaseMoney{
    final private int id;
    private double dept = 0d;
    private ArrayList<BorrowedBook> borrowedBooks = new ArrayList<>();
    
    
    
    
    private static int totalObjects = 0;
    private static List<Member> allMembers = new ArrayList<>();
    
    //===| Constructor
    public Member(String name, String lastName, String email){
        super(name, lastName, email);
        this.id = totalObjects;
        
        
        totalObjects++;
        allMembers.add(this);
    }
    //===| Overrides
    @Override
    public void increaseMoney(double amount){
        this.dept += amount;
    }
    @Override
    public void decreaseMoney(double amount){
        // Exception handling
        if (this.dept < amount){
            throw new IllegalArgumentException("The amount specified is more than this members current dept; please enter a valid amount");
        }
        
        this.dept -= amount;
    }
    
    //===| Other methods
    public void borrowBook(Member this, Book book){
        try{
            book.borrowBook();
            borrowedBooks.add(new BorrowedBook(this, book));
        } catch(Exception e){
            System.err.println("System exception: " + e);
        }
    }
    
    public void returnBook(Book book){
        // Add availability to book
        book.returnBook();
        
        // Safely remove book from list
        Iterator<BorrowedBook> it = borrowedBooks.iterator();
        while(it.hasNext()){
            if (it.next().equals(book)){
                it.remove();
            }
        }
    }
    
    
    public Member lookUp(String firstName, String lastName){
        for (Member member : this.allMembers){
            // If a member is found that matches the lookup parametres
            if (member.firstName.equals(firstName) && member.lastName.equals(lastName)){
                return member;
            }
        }
        // If the member was not found
        return null;
    }
    
    
    //===| Getters and setters
    public double getDept(){
        return this.getDept();
    }
    
    public ArrayList<BorrowedBook> getBorrowedBooks(){
        return borrowedBooks;
    }
    
    
    public static List<Member> listMembers(){
        return allMembers;
    }
    
}
