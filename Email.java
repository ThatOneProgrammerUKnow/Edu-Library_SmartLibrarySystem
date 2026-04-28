package com.mycompany.edu.library_smartlibrarysystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kobus
 */
class Email{
    private String email;

    // ===| Validating an email
    private boolean validEmail(String email){
        // Validation variables
        boolean hasAt = false;
        
        // Updating validation variables
        for (char c : email.toCharArray()){
            // First: Does the email contain an @
            if (c == '@'){
                hasAt = true;
            }
            
            // If an @ is already found, does the email contain a .
            if ((hasAt) && (c == '.')){
                return true;
            } 
        }
        // If an @ and or . was not found
        return false;
    }
    
    // ===| Public getters and setters
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        if (validEmail(email)){
            this.email = email;
        } else{
            throw new IllegalArgumentException("This email is invalid; please enter a valid email");
        }
    }
    
    // ===| Constructor
    public Email(String email){
        setEmail(email);
    }
}
