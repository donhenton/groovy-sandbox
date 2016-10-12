/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.simple

import groovy.transform.Canonical

/**
 *
 * @author dhenton
 */
@Canonical class User {
	Long id;
        String firstName;
        String lastName;
        String email;
        Date dob;
        def  languages = [];
    
     
    
    
    
    String toString()
    {
        firstName +" "+lastName;
    }
    
    void printFullName()
    {
        
       println "My name is $firstName $lastName"
    }
    
}

