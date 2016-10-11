/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.basic

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*; 
import groovy.transform.Canonical
 
 

@Slf4j
@RunWith(JUnit4.class)
class StringTests {
	
    @Test
    public void testPrintFormat()
    {
        
        String name = "bozo"
        String msg = "Hello, ${name}"
        
        assertEquals("Hello, bozo", msg)
        
    }
    
    @Test
    public void testMultipleLine()
    {
        String answer = "Get a job";
        String test = """
        Get 
        a 
        job"""
        
        assertEquals(answer.replaceAll("\\s",""),test.replaceAll("\\s",""))
    }
    
    
    @Test
    public void testDollarEscape()
    {
        String test = $/c:\fred\ted/$
        
        String[] res = test.split("\\\\")
       // res.each  { log.debug(it)}
        assertEquals(3,res.length)
        
        
        
    }
    
}

