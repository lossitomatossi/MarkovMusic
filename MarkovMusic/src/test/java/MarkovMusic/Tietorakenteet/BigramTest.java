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
    Bigram numeroBigram;
    Bigram numeroKohde;
    Bigram numeroKohde2;

    Bigram tekstiBigram;
    Bigram tekstiKohde;
    Bigram tekstiKohde2;

    public BigramTest() {
    }
    
    @Before
    public void setUp() {
        numeroBigram = new Bigram(1, 2);
        numeroKohde = new Bigram(1, 2);
        numeroKohde2 = new Bigram(2, 1);

        tekstiBigram = new Bigram("A", "B");
        tekstiKohde = new Bigram("A", "B");
        tekstiKohde2 = new Bigram("B", "A");

    }

    /**
     * Test of getO1 method, of class Bigram.
     */
    @Test
    public void testGet1() {
        System.out.println("gets1, geti1");
        assertEquals(numeroBigram.getI1(), numeroBigram.i1);
        assertEquals(tekstiBigram.getS1(), tekstiBigram.s1);
        assertNotEquals(numeroBigram.getI1(), numeroKohde2.getI1());
        assertNotEquals(tekstiBigram.getS1(), tekstiKohde2.getS1());
    }

    @Test
    public void testGet2() {
        System.out.println("get2");
        assertEquals(numeroBigram.getI2(), numeroBigram.i2);
        assertEquals(tekstiBigram.getS2(), tekstiBigram.s2);
        assertNotEquals(numeroBigram.getI2(), numeroKohde2.getI2());
        assertNotEquals(tekstiBigram.getS2(), tekstiKohde2.getS2());
    }

    /**
     * Test of toString method, of class Bigram.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("NumeroBigram(1,2)", numeroBigram.toString());
        assertEquals("TekstiBigram(A,B)", tekstiBigram.toString());
    }
    
    /**
     * Test of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals() {
        assertEquals(numeroBigram, numeroBigram);
    }
    
    /**
     * Test2 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals2() {
        assertEquals(numeroBigram, numeroKohde);
    }
    
    /**
     * Test3 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals3() {
        assertEquals(false, numeroBigram.equals(""));
    }
    
     /**
     * Test4 of equals method, of class Bigram.
     */
    
    @Test
    public void testEquals4() {
        assertEquals(false, numeroBigram.equals(numeroKohde2));
    }
    
    /**
     * Test of hashCode method, of class Bigram.
     */
    
    @Test
    public void testHashCode() {
        assertEquals(numeroBigram.hashCode(), numeroKohde.hashCode());
    }
}