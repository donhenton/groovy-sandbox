/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.ast

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
class AstTests   {
	
    private CanonicalThing canonicalInstance = new CanonicalThing()
    private HashCodeEqualsThing hashCodeInstance = new HashCodeEqualsThing()
    private List<LibraryBook> books  
    
    @Before
    public void beforeTest()
    {
        books = new ArrayList<LibraryBook>()
        books << (new LibraryBook("aa1","The Velveteen Hamster"))
        books << (new LibraryBook("bb1","Confessions of A Unemployed Programmer"))
         
    }
    
    @Test
    public void testCanonicalHasConstructor()
    {
        assert books != null
        assert books.size() == 2
        assert books.get(0).title.equals("The Velveteen Hamster")
        //log.debug(books.toString())
    }
    
    @Test
    public void testLoggerNotNull()
    {
        assertNotNull(log);
    }
    
    @Test(expected=RuntimeException.class)
    public void NonCanoncialHasNoTupleConstructor()
    {
       def hTest =  new HashCodeEqualsThing("fred");
       assertEquals(hTest.first,"fred")
    }
    
    @Test 
    public void NonCanoncialHasNamedConstructor()
    {
       def hTest =  new HashCodeEqualsThing(first: "fred");
       assertEquals(hTest.first,"fred")
    }
    
}

@Canonical class LibraryBook
{
    String ISBN
    String title
    
}



@Canonical class CanonicalThing
{
    String first, last
    int age
    Collection<LibraryBook> books
}


@EqualsAndHashCode class HashCodeEqualsThing
{
    String first, last
    int age
    Collection<LibraryBook> books
}