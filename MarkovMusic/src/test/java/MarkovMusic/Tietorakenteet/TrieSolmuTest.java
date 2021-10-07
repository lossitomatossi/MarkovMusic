package MarkovMusic.Tietorakenteet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class TrieSolmuTest {
    private TrieSolmu ts;

    public TrieSolmuTest() {
    }
    
    @Before
    public void setUp() {
        this.ts = new TrieSolmu(1);
    }

    /**
     * Test of lisaaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testLisaaLapsi() {
        System.out.println("lisaaLapsi");
        ts.lisaaSolmu(0);
        assertEquals(1, ts.painojenLkm());
    }

    /**
     * Test of juureenLisatty method, of class TrieSolmu.
     */
    @Test
    public void testJuureenLisatty() {
        System.out.println("juureenLisatty");
        assertEquals(0, ts.painojenLkm());
        ts.lisaaSolmu(1);
        assertEquals(1, ts.painojenLkm());
    }

    /**
     * Test of satunnaisluku method, of class TrieSolmu.
     */
    @Test
    public void testSatunnaisluku() {
        System.out.println("satunnaisluku");
        Boolean tulos = ts.satunnaisluku() <= ts.painojenLkm();
        assertEquals(true, tulos);
    }

    /**
     * Test of valitseSolmu method, of class TrieSolmu.
     */
    @Test
    public void testValitseSolmu() {
        System.out.println("valitseSolmu");
        assertEquals(null, ts.valitseSolmu());
    }
    
        /**
     * Test of valitseSolmu method, of class TrieSolmu.
     */
    @Test
    public void testValitseSolmu2() {
        System.out.println("valitseSolmu2");
        ts.lisaaSolmu(0);
        assertNotEquals(null, ts.valitseSolmu());
        assertEquals(TrieSolmu.class, ts.valitseSolmu().getClass());
    }

    /**
     * Test of painojenLkm method, of class TrieSolmu.
     */
    @Test
    public void testPainojenLkm() {
        System.out.println("lapsienLkm");
        assertEquals(0, ts.painojenLkm());
        ts.lisaaSolmu(1);
        assertEquals(1, ts.painojenLkm());
    }

    /**
     * Test of palautaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testPalautaSolmu() {
        System.out.println("palautaSolmu");
        ts.lisaaSolmu(1);
        assertEquals(TrieSolmu.class, ts.palautaSolmu(0).getClass());
        assertNotEquals(null, ts.palautaSolmu(1));
    }

}
