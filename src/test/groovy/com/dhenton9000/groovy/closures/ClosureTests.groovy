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
 
    private Closure plus = {a,b -> a+b}
    private Closure mult = {a,b -> a*b}
    
    private Closure readClosureProps = { Closure t ->
        
        ["maxNumParams":t.maximumNumberOfParameters,"paramTypes": t.parameterTypes]
        
    }
    
    @Test
    public void testClosureAsClass()
    {
        def someClosure = {int x, y -> x + y}
        
        Map res = readClosureProps(someClosure)
        assertEquals(2,res.maxNumParams)
        
        java.lang.Class[] cl = res.paramTypes;
        assertEquals("int",cl[0].name)
        assertEquals(java.lang.Object,cl[1])
        
    }
    
    
    
    @Test
    public void testSimpleClosure()
    {
       
        
        def multChanger = new NumberChanger(mult)
        def plusChanger = new NumberChanger(plus)
        
        assertEquals(10,multChanger.changeNumber(5,2))
        assertEquals(7,plusChanger.changeNumber(5,2))
    }
        
    @Test
    public void testCurry()
    {
        Closure fA = {a,b -> "My greeting is ${a}, ${b}"}
        assertEquals("My greeting is Geta job, Tom",fA("Geta job","Tom").toString())
         
        Closure fB = fA.curry("Smoke it you've got it");
        
        assertEquals("My greeting is Smoke it you've got it, Fred",fB("Fred").toString())
          
    }
    
    
    @Test
    public void testSimplifiedSyntax()
    {
        final List<Integer> val = new ArrayList<Integer>();
        Closure timesTen = {num,  c -> c(num*10) }
            
        timesTen(10) {
            val.add(it)
        }
        assertEquals(100,val.get(0))
        
    }
    
    
    @Test 
    public void testBlockParametersAllow()
    {
        final List<Integer> val = new ArrayList<Integer>();
        def f1 = {val.add(5)}
          
        f1(25)
        assertEquals(1,val.size())
        
        
    }
    
    @Test(expected=MissingMethodException.class)
    public void testBlockParametersBlock()
    {
        final List<Integer> val = new ArrayList<Integer>();
        def f1 = { ->val.add(5)}
          
        f1(25)
    }
    
    
    
    @Test(expected=MissingMethodException.class)
    public void testMultipleArgumentsCountIsEnforced()
    {
        final List<String> val = new ArrayList<String>();
        def f1 = {a,b -> val.add(a); val.add(b)}
        
        f1("a")
       
        assertEquals(1,val.size())
        
        
    }
    
     @Test 
    public void testMultipleArguments()
    {
        final List<String> val = new ArrayList<String>();
        final String[] testArray = {}
        
        def f1 = {String ... args ->  
            //assertEquals((testArray.class.name).class.name,args.class.name)
            assertTrue(args instanceof String[])
            ArrayList<String> argList =  Arrays.asList(args)
            argList.forEach({t -> val.add(t)}); 
        }
        f1("a")
       
        assertEquals(1,val.size())
        
        f1("b","c","d")
       
        assertEquals(4,val.size())
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