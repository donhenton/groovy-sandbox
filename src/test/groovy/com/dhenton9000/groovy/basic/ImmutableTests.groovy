package com.dhenton9000.groovy.basic
import groovy.transform.Immutable
/**
 *
 * @author dhenton
 */
class ImmutableTests extends GroovyTestCase {
	
    public void testImmutable()
    {
        def d = new Date()
        def c1 = new Customer(first:'Tom', last:'Jones', age:21, since:d, favItems:['Books', 'Games'])
        def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])
        assert c1 == c2
    }
    
    public void testCantModifyFields()
    {
        def d = new Date()
        def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])
        shouldFail(ReadOnlyPropertyException)
        {
            c2.first = "bonzo"
        }
          
    }
    
     public void testCantModifyCollections()
    {
        def d = new Date()
        def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])
        assert 2 == c2.favItems.size()
         
        shouldFail(UnsupportedOperationException)
        {
            c2.favItems.add("bonzo")
        }
        //if you don't have immutable you can add things
        Collection k = new ArrayList<String>()
        k.add("bonzo")
          
    }
}

@Immutable
class Customer {
    String first, last
    int age
    Date since
    Collection favItems
}
 