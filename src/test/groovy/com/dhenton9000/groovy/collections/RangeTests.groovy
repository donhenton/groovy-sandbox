
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
class CollectionsTests {
	
    
    
    @Test
    public void testFullRange()
    {
        Range r = 1..10
        final List t = new LinkedList<Integer>();
        r.each({
                t.add(it)  
            })
    
        assertEquals(10, t.size())
        assertEquals(10,t.getLast())
        
    }
    @Test
    public void testHalfExclusiveRange()
    {
        Range r = 1..<10
        final List t = new LinkedList<Integer>();
        r.each({
                t.add(it)  
            })
    
        assertEquals(9, t.size())
        assertEquals(9,t.getLast())
    }
    
    @Test
    public void testHalfExclusiveRangeWithSimpleSyntax()
    {
       
    
        assertTrue((1..<10).contains(9))
        assertFalse((1..<10).contains(10))
    }
    
    
    
    @Test
    public void testUsingDates()
    {
        Date today = new Date();
        Date oneWeekAway = today + 7
        Date testDate = (today..oneWeekAway).get(1)
        assertEquals(today+1,testDate)
        
        
    }
    
    
    @Test
    public void testUsingLetters()
    {
         Range letters = 'a'..'z'
         assertEquals(26,letters.size())
        
    }
    
}

