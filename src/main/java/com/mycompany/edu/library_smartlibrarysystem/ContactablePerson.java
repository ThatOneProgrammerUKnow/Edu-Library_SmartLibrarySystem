package com.mycompany.edu.library_smartlibrarysystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kobus
 */
abstract public class ContactablePerson extends Person {
    Email email;
    
    //===| Constructor
    public ContactablePerson(String name, String lastName, String email){
        super(name, lastName);
        this.email = new Email(email);
    }
    
    //===| Setters and getters
    public String getEmail(){
        return this.email.getEmail();
    }
    
    public void setEmail(String email){
        this.email.setEmail(email);
    }
}
