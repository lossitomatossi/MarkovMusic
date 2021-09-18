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
        assertEquals(stringBigram.getO1(), stringKohde.getO1());
    }

    @Test
    public void testGetO1ver2() {
        System.out.println("getO1ver2");
        assertNotEquals(testiBigram.getO1(), kohdeBigram2.getO1());
        assertNotEquals(stringBigram.getO1(), stringKohde2.getO1());
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
     * Test 1 of equals method, of class Bigram.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertEquals(true, testiBigram.equals(kohdeBigram));
    }

    /**
     * Test 2 of equals method, of class Bigram.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        assertEquals(false, testiBigram.equals(kohdeBigram2));
    }

    /**
     * Test 3 of equals3 method, of class Bigram.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        assertEquals(true, testiBigram.equals(testiBigram));
    }

    /**
     * Test 4 of equals method, of class Bigram.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        String testi = "";
        assertEquals(false, testiBigram.equals(testi));
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
