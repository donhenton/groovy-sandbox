/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.simple

/**
 *
 * @author dhenton
 */
class User {
	Long id;
        String firstName;
        String lastName;
        String email;
        Date dob;
        
    
    User(String f, String l)
    {
        this.firstName = f;
        this.lastName = l;
        
    }
    
    String toString()
    {
        firstName +" "+lastName;
    }
    
}

