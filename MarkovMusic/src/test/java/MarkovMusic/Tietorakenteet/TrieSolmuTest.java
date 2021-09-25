package MarkovMusic.Tietorakenteet;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class TrieSolmuTest {
    TrieSolmu oletettu;
    
    public TrieSolmuTest() {
        this.oletettu = new TrieSolmu("oletettu", false);
    }
    
    
    @Before
    public void setUp() {
        HashMap<Bigram, Double> lisattavat = new HashMap();
        Bigram teksti1 = new Bigram("A", "A");
        Bigram teksti2 = new Bigram("A", "B");
        lisattavat.put(teksti1, 1.0);
        lisattavat.put(teksti2, 2.0);
        this.oletettu.lisaaLapset(lisattavat);
    }
    

    /**
     * Test of lisaaLapset method, of class TrieSolmu.
     */
    @Test
    public void testLisaaLapset() {
        System.out.println("lisaaLapset");
        HashMap<Bigram, Double> testattavat = new HashMap();
        TrieSolmu testi = new TrieSolmu("testi", false);
        Bigram teksti1 = new Bigram("A", "A");
        Bigram teksti2 = new Bigram("A", "B");
        testattavat.put(teksti1, 1.0);
        testattavat.put(teksti2, 2.0);
        testi.lisaaLapset(testattavat);
        assertEquals(oletettu.getLapset().get("A"), testi.getLapset().get("A"));
        
        
    }
    
}
