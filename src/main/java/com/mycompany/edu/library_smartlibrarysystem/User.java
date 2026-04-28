/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
public class User extends ContactablePerson{
    final private int id;
    private String userName;
    private String password;
    
    static int totalObjects = 0;
   //===| Constructor
    public User(String name, String lastName, String userName, String email, String password){
        super(name, lastName, email);
        this.id = totalObjects;
        this.userName = userName;
        this.password = password;
        
        totalObjects++;
    }
    
    // Other
    public boolean verifyPassword(String password){
        if (this.password.equals(password)){
            return true;
        }
        return false;
    }
    
    
    // Getters and setter
    public int getId(){
        return this.id;
    }
    
    public String getUsername(){
        return this.userName;
    }
    
    public void setUsername(String username){
        this.userName = username;
    }
}
