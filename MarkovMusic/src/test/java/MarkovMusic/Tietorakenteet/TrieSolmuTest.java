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
        this.ts = new TrieSolmu();
    }

    /**
     * Test of lisaaLapsi method, of class TrieSolmu.
     */
    @Test
    public void testLisaaLapsi() {
        System.out.println("lisaaLapsi");
        ts.lisaaLapsi(0);
        assertEquals(1, ts.lapsienLkm());
    }

    /**
     * Test of juureenLisatty method, of class TrieSolmu.
     */
    @Test
    public void testJuureenLisatty() {
        System.out.println("juureenLisatty");
        assertEquals(0, ts.lapsienLkm());
        ts.lisaaLapsi(1);
        assertEquals(1, ts.lapsienLkm());
    }

    /**
     * Test of satunnaisluku method, of class TrieSolmu.
     */
    @Test
    public void testSatunnaisluku() {
        System.out.println("satunnaisluku");
        Boolean tulos = ts.satunnaisluku() <= ts.lapsienLkm();
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
        ts.lisaaLapsi(0);
        assertNotEquals(null, ts.valitseSolmu());
    }

}
