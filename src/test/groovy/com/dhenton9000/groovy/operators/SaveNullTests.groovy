 

package com.dhenton9000.groovy.operators

 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*; 
import com.dhenton9000.groovy.simple.User
import groovy.transform.Canonical
 
 

@Slf4j
@RunWith(JUnit4.class)
class SaveNullTests {
    
    private List<LibraryBook> books  
    private List<LibraryBook> nullBooks   
    
	
     @Before
    public void beforeTest()
    {
        books = new ArrayList<LibraryBook>()
        books << (new LibraryBook("aa1","The Velveteen Hamster"))
        books << (null)
        books << (new LibraryBook())
         
    }
    
    @Test
    public void testSafeNull()
    {
        String ISBN = books.get(2).ISBN?.subtring(0,5);
        assertNull(ISBN)
        ISBN = books.get(2)?.ISBN;
        assertNull(ISBN)
    }
    
    @Test
    public void testSafeNullNormal()
    {
        String ISBN = books.get(0).ISBN?.toUpperCase();
        assertEquals("AA1",ISBN)
    }
    
    @Test 
    public void testElvisOperator()
    {
         
        def player = new User(22,'fred','farkel','ffarkel@gumdrop.com')
        String javaDisplayName = player.firstName == null ? player.email : player.firstName;
        def groovyDisplayName = player.firstName ?: player.email
        assertEquals(javaDisplayName,groovyDisplayName)
        
        
        player = new User(22,null,'farkel','ffarkel@gumdrop.com')
        javaDisplayName = player.firstName == null ? player.email : player.firstName;
        groovyDisplayName = player.firstName ?: player.email
        assertEquals(javaDisplayName,groovyDisplayName)
      
    }
    
    
    @Test
    public void testElvisOnObjects()
    {
        LibraryBook m = new LibraryBook('bbb','Smurfs Fovever')
        
        LibraryBook lib = m ?: new LibraryBook('aaa',"Bonzo's night out")
        
        assertEquals("bbb",lib.ISBN)
        m = null
        lib = m ?: new LibraryBook('aaa',"Bonzo's night out")
    }
    
    
}


@Canonical class LibraryBook
{
    String ISBN
    String title
    
}
