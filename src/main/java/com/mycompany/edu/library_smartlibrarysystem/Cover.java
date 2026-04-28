/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.library_smartlibrarysystem;

/**
 *
 * @author kobus
 */
public class Cover {
    final private int id;
    final private String type;
    
    static private int totalObjects = 0;
    
    //===|Constructor
    public Cover(String type){
        this.type = type;
        this.id = totalObjects;
        
        totalObjects++;
    }
    
    //===| Getters and setters
    public String getType(){
        return this.type;
    }
}
