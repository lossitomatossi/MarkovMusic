/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic.Algoritmit;

import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class MerkkienTuottajaTest {
    private MerkkienTuottaja oletusMT;
    
    public MerkkienTuottajaTest() {
    }
    
    @Before
    public void setUp() {
        this.oletusMT = new MerkkienTuottaja(123);
        
    }
    
    
    /**
     * Testaa metodia tuotaTaajuuksia, luokka : MerkkienTuottaja.
     */
    @Test
    public void testTuotaTaajuuksia() {
        System.out.println("tuotaTaajuuksia");
        int pituus = 3;
        MerkkienTuottaja mt = new MerkkienTuottaja(123);
        List<Integer> oletusTaajuudet = oletusMT.tuotaTaajuuksia(pituus);
        List<Integer> tulosTaajuudet = mt.tuotaTaajuuksia(pituus);
        assertEquals(oletusTaajuudet, tulosTaajuudet);
    }
    
}
