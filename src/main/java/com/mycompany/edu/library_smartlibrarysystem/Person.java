package com.mycompany.edu.library_smartlibrarysystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kobus
 */

// Generic parent 'Person' that only includes someones name and lastName
abstract public class Person {
    protected String firstName;
    protected String lastName;
    
    //===| Constructor
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // =====| Public getters |=====
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    // =====| Public setters |=====
    protected void setName(String firstName){
        this.firstName = firstName;
    }
    
    protected void setLastName(String lastName){
        this.lastName = lastName;
    }
}
