

package com.dhenton9000.groovy.closures;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;


@Slf4j("LOG")
public class DelegateTests {
    
     
    
 
 
    /**
    'this' inside a closure refers to the containing class
     */
    @Test
    public void testDefinitionOfThisInClosure()
    {
        final String t = this.class.name
        
        Closure test = { assertEquals(t,this.class.name) }
        
        assertEquals("com.dhenton9000.groovy.closures.DelegateTests",t)
        
        
    }
    
    @Test
    public void testNesting()
    {
        def s = new ScopeDemo();
        
        s.startTest()
        s.answerMap.each{ k, v -> LOG.debug "${k}:${v}" }
        
    }
    
    
}

@Slf4j("LOG")
class ScopeDemo
{
    
    public final Map answerMap = new HashMap<String>();
    public scopeName = "scopeName"
  
    private Closure readClosureProps = { Closure t ->
        
        ["maxNumParams":t.maximumNumberOfParameters,"paramTypes": t.parameterTypes,
         "thisClassName": this.class.name,"ownerClassName": owner.class.name,
        "delegateClassName": delegate.class.name]
        
    }
    
    
    def outerClosure = {
        
        LOG.debug("in outer");
        String name ="outerClosure"
        
        Closure outerPropReader = { Closure t ->
        
            ["maxNumParams":t.maximumNumberOfParameters,"paramTypes": t.parameterTypes,
         "thisClassName": this.class.name,"ownerClassName": owner.class.name,
        "delegateClassName": delegate.class.name]
        
        }
    
        assertEquals("outerClosure", name)
        def nestedClosure = 
        {
            LOG.debug("in nested")
            answerMap.put("NESTED",outerPropReader(owner))
            assertEquals("scopeName",this.scopeName)
            assertEquals("outerClosure",name)
            //assertEquals("outerClosure",owner.name)
        }
        answerMap.put("OUTER",outerPropReader(nestedClosure))
        nestedClosure()
        
        
        
    }
    
    void startTest()
    {
        answerMap.put("CLASS",readClosureProps(outerClosure))
        outerClosure();
    }
    
    
}
 
