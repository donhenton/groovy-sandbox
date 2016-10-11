/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.basic
import groovy.util.logging.Slf4j

/**
 * this shows that strings can be cohered to other values
 * 
 * @author dhenton
 */

class BoxingTests extends GroovyTestCase {
    
    
    void testBoxing()
    {

        def testBox = new BoxSample(10)
        assert testBox.i == 20
    }
    
    void testCompareRight()
    {

        def testBox = new BoxSample(10)
        assert (testBox.compareRight(30))
        assert (testBox.compareRight(15))
         
    }
    
    void testCompareWrong()
    {

        def testBox = new BoxSample(10)
        assert (testBox.compareWrong(30))
        assert (testBox.compareWrong(15))
        assert testBox.compareWrong(15).class.name.equals("java.lang.String")
        assert testBox.compareWrong(15).equals("1")
        assert testBox.compareWrong(30).equals("-1")
    }
}



@Slf4j
class BoxSample
{
    int i;
    
    BoxSample(j)
    {
        this.i = j * 2
       
    }
    
    String compareWrong(k)
    {
        return i.compareTo(k);
    }
    Boolean compareRight(k)
    {
      //  log.debug("comparing $i to $k")
        return i.compareTo(k);
    }
}

