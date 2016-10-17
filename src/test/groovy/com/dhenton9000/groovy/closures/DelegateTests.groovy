

package com.dhenton9000.groovy.closures;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;


@Slf4j("LOG")
public class DelegateTests {
    
     private final ArrayList<String> testList = new ArrayList<String>();
    
    @Before
    public void setTest()
    {
        
        testList.clear();
        
    }
    
    public void append(String s)
    {
        testList.add(s+"z");
    }
 
 
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
       // s.answerMap.each{ k, v -> LOG.debug "${k}:${v}" }
        
        assertEquals(s.answerMap.get("CLASS").thisClassName,s.answerMap.get("NESTED").thisClassName)
        assertNotEquals(s.answerMap.get("CLASS").ownerClassName,s.answerMap.get("NESTED").ownerClassName)
        
    }
    
    @Test
    public void testNoChangeDelegate()
    {
        def testWriter = { 
            append "apples"
            append "oranges"
        }
        def ans = testWriter()
        assertNull(ans)
        assertEquals(2,testList.size());
        assertEquals("applesz",testList.get(0))
    }
    
     @Test
    public void testChangingDelegateDoesntTakeBecauseOfSearchStrategy()
    {
         
        StringBuffer sb = new StringBuffer()
        
        //still go to the class level method here
        
        def testWriter = { 
            append "apples"
            append "oranges"
        }
        testWriter.delegate = sb
        
        def ans = testWriter()
        
        assertEquals(2,testList.size());
        assertEquals("applesz",testList.get(0))
    }
    
     @Test
    public void testChangingDelegateWorksNow()
    {
         
        StringBuffer sb = new StringBuffer()
        
        //force the resolve strategy which does two things
        //creates a return value
        //appends using stringbuffer
        
        
        def testWriter = { 
            append "apples"
            append "oranges"
        }
        testWriter.delegate = sb
        testWriter.resolveStrategy = Closure.DELEGATE_ONLY
        def ans = testWriter()
        assertNotNull(ans)
        assertEquals(0,testList.size());
        assertEquals("applesoranges",ans.toString())
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
 
