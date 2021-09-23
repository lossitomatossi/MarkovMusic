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
        HashMap<String, Integer> lisattavat = new HashMap();
        lisattavat.put("A", 1);
        lisattavat.put("B", 2);
        this.oletettu.lisaaLapset(lisattavat);
    }
    

    /**
     * Test of lisaaLapset method, of class TrieSolmu.
     */
    @Test
    public void testLisaaLapset() {
        System.out.println("lisaaLapset");
        HashMap<String, Integer> testattavat = new HashMap();
        TrieSolmu testi = new TrieSolmu("testi", false);
        testattavat.put("B", 2);
        testattavat.put("A", 1);
        testi.lisaaLapset(testattavat);
        assertEquals(oletettu.getLapset().get("A"), testi.getLapset().get("A"));
        
        
    }
    
}
