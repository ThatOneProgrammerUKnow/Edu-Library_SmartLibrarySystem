/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
public class Category {
    final private int id;
    final private String categoryName;
    
    static private int totalObjects = 0;
    
    //===| Constructor
    public Category(String name){
        this.categoryName = name;
        this.id = totalObjects;
        
        totalObjects++;
    }
    
    //===| Getters and setters
    public String getName(){
        return this.categoryName;
    } 
}
