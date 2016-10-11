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
class UserTests extends GroovyTestCase   {
	
     void testUserCreation()
     {
         User u = new User(firstName: "fred",lastName: "farkel");
         assert u.toString().equals("fred farkel");
         
        // u.printFullName()
        
     }
    
    
}

