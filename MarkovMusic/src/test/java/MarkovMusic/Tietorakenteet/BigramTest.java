/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic.Tietorakenteet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class BigramTest {
    Bigram testiBigram;
    Bigram kohdeBigram;
    Bigram kohdeBigram2;

    
    public BigramTest() {
    }
    
    @Before
    public void setUp() {
        testiBigram = new Bigram(1, 2);
        kohdeBigram = new Bigram(1, 2);
        kohdeBigram2 = new Bigram(2, 1);

    }
    
    @After
    public void tearDown() {
    }

    /**
    * Test of getO1 method, of class Bigram.
    */
    @Test
    public void testGetO1ver1() {
        System.out.println("getO1ver1");
        assertEquals(testiBigram.getO1(), kohdeBigram.getO1());
    }

    @Test
    public void testGetO1ver2() {
        System.out.println("getO1ver2");
        assertNotEquals(testiBigram.getO1(), kohdeBigram2.getO1());
    }

    /**
    * Test of getO2 method, of class Bigram.
    */
    @Test
    public void testGetO2ver1() {
        System.out.println("getO2ver1");
        assertEquals(testiBigram.getO2(), kohdeBigram.getO2());
    }

    @Test
    public void testGetO2ver2() {
        System.out.println("getO2ver2");
        assertNotEquals(testiBigram.getO2(), kohdeBigram2.getO2());
    }


    /**
     * Test of equals method, of class Bigram.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertEquals(true, testiBigram.equals(kohdeBigram));
    }

    /**
     * Test of equals method, of class Bigram.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        assertEquals(false, testiBigram.equals(kohdeBigram2));
    }

    /**
     * Test of hashCode method, of class Bigram.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(testiBigram.hashCode(), kohdeBigram.hashCode());
        
    }
    
    /**
     * Test of hashCode method, of class Bigram.
     */
    @Test
    public void testHashCode2() {
        System.out.println("hashCode2");
        assertNotEquals(testiBigram.hashCode(), kohdeBigram2.hashCode());
        
    }
}
