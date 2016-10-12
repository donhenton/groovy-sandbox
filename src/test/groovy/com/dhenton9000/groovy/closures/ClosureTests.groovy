/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.closures

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;
 
@Slf4j("LOG")
class ClosureTests {
 
    
    @Test
    public void testSimpleClosure()
    {
        Closure plus = {a,b -> a+b}
        Closure mult = {a,b -> a*b}
        
        def multChanger = new NumberChanger(mult)
        def plusChanger = new NumberChanger(plus)
        
        assertEquals(10,multChanger.changeNumber(5,2))
        assertEquals(7,plusChanger.changeNumber(5,2))
    }
    	
}

class NumberChanger
{
    Closure action;
    NumberChanger(Closure c)
    {
       this.action = c 
    }
    
    
    public changeNumber(n,m)
    {
        this.action(n,m)
    }
    
    
    
}