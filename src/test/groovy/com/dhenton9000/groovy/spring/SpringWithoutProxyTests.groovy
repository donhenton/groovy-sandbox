/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.groovy.spring

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional

import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import static org.junit.Assert.*;
import com.dhenton9000.groovy.simple.User
import groovy.sql.Sql


@RunWith(SpringRunner.class)
@Transactional
@Slf4j("LOG")
@ContextConfiguration(value="classpath:spring-config.xml")
class SpringWithoutProxyTests {

    @Autowired
    private User user;
    
    @Autowired
    Sql sql
    
    
    
    
    @Test
    public void testSql()
    {
        assertNotNull(sql)
        def counter = 0;
        
         sql.eachRow("select * from users where login = 'fff'") { row ->
           counter ++;
        }
        assertEquals(0,counter);
        counter = 0;
        
        def params = ['fff','Fred F Farkel']
        sql.execute 'INSERT INTO users (login, username)  values (?, ?)', params
        
         sql.eachRow("select * from users where login = 'fff'") { row ->
           counter ++;
        }
        assertEquals(1,counter)
    }
    
	
}

