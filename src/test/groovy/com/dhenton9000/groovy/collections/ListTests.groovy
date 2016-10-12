
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
    @Test
    void testIterateWithEach() {
        def products = ['GitHub', 'Confluence', 'Hipmunk', 'Outlook']

        // It's very common to iterate through lists. Can it get simpler than this?
        for (String s : products) {
            println s
        }
        // In Groovy, it can.
        products.each {
            println it
        }

        Map<String, String> idToNameMap = [333: 'Matthew', 233: 'Christopher', 133: 'Dominic']


        List<String> javaIdListResult = new LinkedList<String>();
        for (Map.Entry<String, String> entry : idToNameMap) {
            javaIdListResult.add(entry.getKey() + entry.getValue());
        }

        // How would you do this in Groovy?
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
        def idListResult = []

        idToNameMap.each({k,v -> idListResult.push(k+v)})


        assertEquals(idListResult ,['333Matthew', '233Christopher', '133Dominic'])
    }
    
    @Test
    public void testInKeyword()
    {
        String str = "this is me "
        List list = str.tokenize(" ")
        String word = "this"
        assert  word in list == true
        assert  "hello" in list == false
    }
	
}

