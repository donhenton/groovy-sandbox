/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.control.structure

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;


@Slf4j("LOG")
class TruthTests {
    
    @Test
    public void testBoolean()
    {
        Boolean t = true;
        
        assertTrue(t)
    }
    
    @Test
    public void testNonEmptyCollectionIsTrue()
    {
        List t = new ArrayList();
        
         
        assertTrue(t.empty)
        if (t)
        {
            fail("empty array yielded true") 
        }
        t.add("a")
        if (!t)
        {
            fail("filled array yielded false") 
        }
        t.clear()
        assertTrue(t.empty)
    }
    
    @Test
    public void testNonEmptyMapIsTrue()
    {
        Map t = new HashMap();
      
        if (t)
        {
            fail("empty map yielded true") 
        }
        t.put("a","a")
        if (!t)
        {
            fail("filled map yielded false") 
        }

    }
    
    
    @Test
    public void testNonEmptyStringIsTrue()
    {
        String t = null;
      
        if (t)
        {
            fail("empty string yielded true") 
        }
        t = "a"
        if (!t)
        {
            fail("filled string yielded false") 
        }
        t = "";
        if (t)
        {
            fail("filled string with zero length should yield false") 
        }

    }
    
    @Test
    public void testNonNullObjectIsTrue()
    {
        Closure t = null;
      
        if (t)
        {
            fail("empty closure yielded true") 
        }
        t =  {a -> a*5}
        if (!t)
        {
            fail("filled closure yielded false") 
        }
         

    }
    
     @Test
    public void testNumberTruth()
    {
        int t = 0;
      
        if (t)
        {
            fail("zero in yielded true") 
        }
        t = 5
        if (!t)
        {
            fail("integer yielded false") 
        }
        

    }
    
     @Test
    public void testNonEmptyCharIsTrue()
    {
        def t ;
      
        if (t)
        {
            fail("empty char yielded true") 
        }
        t = 'c'
        if (!t)
        {
            fail("filled char yielded false") 
        }
         

    }
	
}

