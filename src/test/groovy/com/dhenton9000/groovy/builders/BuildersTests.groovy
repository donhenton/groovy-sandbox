

package com.dhenton9000.groovy.builders

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*;
import groovy.xml.MarkupBuilder


/**
 *
 * @author dhenton
 */
@RunWith(JUnit4.class)
@Slf4j
class BuildersTests {
	
    private MarkupBuilder builder
    private StringWriter writer
    
    @Before
    public void beforeTest()
    {
        writer = new StringWriter()
        builder = new MarkupBuilder(writer)
    }
    
    
    @Test
    public void testSetup()
    {
        
        
        
        
    }
    
    
}

