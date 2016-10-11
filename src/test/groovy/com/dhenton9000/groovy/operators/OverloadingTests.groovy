/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.operators

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*; 
import groovy.transform.Canonical
 
 

@Slf4j
@RunWith(JUnit4.class)
class OverloadingTests {
	
    @Test
    public void testOverloading()
    {
        MilkCarton a = new MilkCarton(5)
        MilkCarton b = new MilkCarton(2)
        MilkCarton c = a + b
        assertEquals(7,c.capacity)
        
    }
    
    
}

@Canonical class MilkCarton
{
    int capacity = 1;
    MilkCarton plus(MilkCarton b)
    {
        return new MilkCarton(capacity +b.capacity)
    }
}
