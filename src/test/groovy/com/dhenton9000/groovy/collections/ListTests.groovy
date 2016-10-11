/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.collections

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*;
 


/**
 *
 * @author dhenton
 */
@RunWith(JUnit4.class)
@Slf4j
class ListTests {
    
    def nums = [1,2,3,4,5,6,7,9,4,5,3,36,8,9]
    
    
    @Test
    public void testClassOfList()
    {
        assertTrue(nums.getClass().equals(ArrayList.class))
    }
    
    
    @Test
    public void testSomeExoticMethods()
    {
        def res = nums.findResults{
                
            (it == 3) ? it: null
                
        }
        
        assertEquals(2,res.size())
    }
    
    @Test
    public void testPlusForList()
    {
        def newList = nums + [3,3]       
        def res = newList.findResults{               
            (it == 3) ? it: null               
        }
        
        assertEquals(4,res.size())
        
        //original list left unchanged
        
        res = nums.findResults{                
            (it == 3) ? it: null                
        }       
        assertEquals(2,res.size())
    }
    
    
    @Test
    public void testFlatten()
    {
        def firstList = [1]
        firstList << ['a','b']
          
        def flatList = firstList.flatten()
//        for(z in flatList)
//        {
//             log.debug("value ${z} class ${z.class.name}")
//        }
        assertEquals(ArrayList.class,firstList.get(1).class)
        assertEquals(String.class,flatList.get(1).class)
    }
    
    
    @Test
    public void testMapDef()
    {
        def person = [first:"Fred",last:"Farkel"]
        assertEquals("Fred",person.first)
         
    }
	
}

