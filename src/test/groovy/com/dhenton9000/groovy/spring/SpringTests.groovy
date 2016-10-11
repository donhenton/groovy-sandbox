/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.spring

import org.springframework.test.context.junit4.SpringRunner;
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import static org.junit.Assert.*;
import com.dhenton9000.groovy.simple.User


@RunWith(SpringRunner.class)
@ContextConfiguration(value="classpath:spring-config.xml")
class SpringTests {

    @Autowired
    private User user;
    
    
    @Test
    public void testSimpleGroovyBean()
    {
        assertNotNull(user)
        assertEquals("Fred",user.firstName)
    }
	
}

