 

package com.dhenton9000.groovy.operators

 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*; 
 
 
public class OperatorTests {
    
    @Test
    public void testWithConstruct()
    {
        
    
    
        def sb = new StringBuilder()
        sb.with {
            append 'Just another way to add '
            append 'strings to the StringBuilder '
            append 'object.'   
        }
 
        assert 'Just another way to add strings to the StringBuilder object.' == sb.toString()
    
    }
    
    
}
