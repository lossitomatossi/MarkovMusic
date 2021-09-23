package MarkovMusic.Algoritmit;

import MarkovMusic.Tietorakenteet.Bigram;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tompp
 */
public class ParinMuodostajaTest {
    List<Integer> taajuudet;
    List<String> nuotit;
    HashMap<Bigram, Long> summat;
    private final ByteArrayOutputStream printti = new ByteArrayOutputStream();
    private final PrintStream alkuperainenPrint = System.out;

    
    public ParinMuodostajaTest() {
    }
    
    
    //lähde stackoverflow
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(printti));
    }
    
    @Before
    public void setUp() {
        this.taajuudet = new ArrayList<>();
        Collections.addAll(taajuudet, 1,2,3,4,5);
        this.nuotit = new ArrayList<>();
        Collections.addAll(nuotit, "A", "F", "G", "F", "H");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testaa metodia muodostaTaajuusParit, luokka: ParinMuodostaja.
     */
    @Test
    public void testMuodostaTaajuusParit() {
        System.out.println("muodostaTaajuusParit");
        
        ParinMuodostaja pm = new ParinMuodostaja();
        List<Bigram> oletettu = new ArrayList<>();
        Bigram eka = new Bigram(1, 2);
        Bigram toka = new Bigram(2, 3);
        Bigram kolmas = new Bigram(3, 4);
        Bigram neljas  = new Bigram(4, 5);
        Collections.addAll(oletettu, eka, toka, kolmas, neljas);
        List<Bigram> tulos = pm.muodostaTaajuusParit(taajuudet);
        assertEquals(oletettu, tulos);
    }

    /**
     * Testaa metodia muodostaNuottiParit, luokka: ParinMuodostaja.
     */
    
    @Test
    public void testMuodostaNuottiParit() {
        System.out.println("muodostaNuottiParit");
        
        ParinMuodostaja pm = new ParinMuodostaja();
        List<Bigram> oletettu = new ArrayList<>();
        Bigram eka = new Bigram("A", "F");
        Bigram toka = new Bigram("F", "G");
        Bigram kolmas = new Bigram("G", "F");
        Bigram neljas  = new Bigram("F", "H");
        Collections.addAll(oletettu, eka, toka, kolmas, neljas);
        List<Bigram> tulos = pm.muodostaNuottiParit(nuotit);
        assertEquals(oletettu, tulos);
    }
    
//    @Test
//    public void testSummaaNuottiParit() {
//        ParinMuodostaja pm = new ParinMuodostaja();
//        List<Bigram> oletettu = new ArrayList<>();
//        Bigram eka = new Bigram("A", "F");
//        Bigram toka = new Bigram("F", "G");
//        Bigram kolmas = new Bigram("G", "F");
//        Collections.addAll(oletettu, eka, toka, kolmas);
//        pm.summaaNuottiParit(pm.muodostaNuottiParit(oletettu));
//        assertEquals("kakka")
//        
//    }

    
}
