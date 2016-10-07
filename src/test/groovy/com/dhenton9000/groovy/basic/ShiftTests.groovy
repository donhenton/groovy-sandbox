/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.basic

import com.dhenton9000.groovy.simple.User

/**
 *
 * @author dhenton
 */
class ShiftTests extends GroovyTestCase {
	
    void test_shiftOperator()
    {
        
        User u = new User(firstName: "fred",lastName: "farkel");
        
        assert u.languages.size() == 0;
        
        u.languages <<  "English"  
        u.languages <<  "Spanish"
        assert u.languages.size() == 2;
        
        assert u.languages.class.name == 'java.util.ArrayList'
    }
}

