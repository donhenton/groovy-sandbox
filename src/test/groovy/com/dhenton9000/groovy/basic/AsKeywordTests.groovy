/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.basic

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*;
import java.text.MessageFormat as mf 


/**
 * as keyword used to cooerce 
 * @author dhenton
 */
@RunWith(JUnit4.class)
@Slf4j
class AsKeywordTests {
    
    @Test
    public void testAsKeyword()
    {
        def date = [109, 8, 6] as Date //number of years to add to 1900
        assert 2009 == date[Calendar.YEAR]
        assert 8 == date[Calendar.MONTH]
        assert 6 == date[Calendar.DATE]
        
        
        
    }
    
    @Test
    public void testAliasForImport()
    {
        
        assert 'Simple message!' == mf.format('Simple {0}!', ['message'] as Object[])
        
    }
	
    @Test
    public void testMissingAsShouldFail()
    {
        
        assert 'Simple [message]!' == mf.format('Simple {0}!', ['message'])
        
    }
}

