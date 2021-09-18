/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic.Tietorakenteet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author tompp
 */
public class BigramTest {
    Bigram testiBigram;
    Bigram kohdeBigram;
    Bigram kohdeBigram2;

    Bigram stringBigram;
    Bigram stringKohde;
    Bigram stringKohde2;

    public BigramTest() {
    }
    
    @Before
    public void setUp() {
        testiBigram = new Bigram(1, 2);
        kohdeBigram = new Bigram(1, 2);
        kohdeBigram2 = new Bigram(2, 1);

        stringBigram = new Bigram("A", "B");
        stringKohde = new Bigram("A", "B");
        stringKohde2 = new Bigram("B", "A");

    }

    /**
     * Test of getO1 method, of class Bigram.
     */
    @Test
    public void testGetO1() {
        System.out.println("getO1");
        assertEquals(testiBigram.getO1(), testiBigram.o1);
    }
    
    /**
     * Test of getO1 method, of class Bigram.
     */
    @Test
    public void testGetO1ver2() {
        System.out.println("getO1");
        assertNotEquals(testiBigram.getO1(), kohdeBigram2.getO1());
    }

    @Test
    public void testGetO2() {
        System.out.println("getO2");
        assertEquals(testiBigram.getO2(), testiBigram.o2);
    }
    
    /**
     * Test of getO2 method, of class Bigram.
     */
    @Test
    public void testGetO2ver2() {
        System.out.println("getO2");
        assertNotEquals(testiBigram.getO2(), kohdeBigram2.getO2());
    }

    /**
     * Test of toString method, of class Bigram.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("Bigram(1,2)", testiBigram.toString());
    }
    
    /**
     * Test of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals() {
        assertEquals(testiBigram, testiBigram);
    }
    
    /**
     * Test2 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals2() {
        assertEquals(testiBigram, kohdeBigram);
    }
    
    /**
     * Test3 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals3() {
        assertEquals(false, testiBigram.equals(""));
    }
    
     /**
     * Test4 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals4() {
        assertEquals(false, testiBigram.equals(kohdeBigram2));
    }
    
    /**
     * Test of hashCode method, of class Bigram.
     */
    
    @Test
    public void testHashCode() {
        assertEquals(testiBigram.hashCode(), kohdeBigram.hashCode());
    }
}