 

package com.dhenton9000.groovy.operators

 
import groovy.util.logging.Slf4j
 
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import static org.junit.Assert.*; 
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
    
}


@Canonical class LibraryBook
{
    String ISBN
    String title
    
}
