package MarkovMusic.Tietorakenteet;

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
        assertEquals(-1, ts.satunnaisluku());
        ts.lisaaSolmu(0);
        assertNotEquals(-1, ts.satunnaisluku());
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
        assertEquals(TrieSolmu.class, ts.palautaSolmu(1).getClass());
        assertNotEquals(null, ts.palautaSolmu(1));
    }

    /**
     * Test of lisaaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testLisaaSolmu() {
        System.out.println("lisaaSolmu");
        ts.lisaaSolmu(0);
        assertEquals(true, ts.loytyySolmu(0));
    }

    /**
     * Test2 of lisaaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testLisaaSolmu2() {
        System.out.println("lisaaSolmu2");
        ts.lisaaSolmu(0);
        int eka = ts.painojenLkm();
        ts.lisaaSolmu(0);
        assertEquals(true, ts.loytyySolmu(0));
        assertTrue(eka < ts.painojenLkm());
    }

    /**
     * Test of toString method, of class TrieSolmu.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ts.lisaaSolmu(40);
        System.out.println("lisätty solmu " + ts.solmunArvo);
        assertEquals("Solmu 1 johon on lisätty 1 painoa", ts.toString());
    }

    /**
     * Test of poistaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testPoistaSolmu() {
        System.out.println("poistaSolmu");
        ts.lisaaSolmu(0);
        assertEquals(true, ts.loytyySolmu(0));
        ts.poistaSolmu(0);
        assertEquals(false, ts.loytyySolmu(0));
    }
    /**
     * Test of poistaSolmu method, of class TrieSolmu.
     */
    @Test
    public void testPoistaSolmu2() {
        System.out.println("poistaSolmu2");
        ts.lisaaSolmu(0);
        assertEquals(true, ts.loytyySolmu(0));
        ts.poistaSolmu(1);
        assertEquals(true, ts.loytyySolmu(0));
    }

    /**
     * Test of alaSolmut method, of class TrieSolmu.
     */
    @Test
    public void testAlaSolmut() {
        System.out.println("alaSolmut");
        assertEquals(true, ts.alaSolmut().isEmpty());
    }

    /**
     * Test of printtaaTiedot method, of class TrieSolmu.
     */
    @Test
    public void testSolmunTiedot() {
        System.out.println("solmunTiedot");
        ts.lisaaSolmu(2);
        ts.lisaaSolmu(4);
        assertEquals("Solmun alasolmut ovat: 2 4", ts.solmunTiedot());
    }

    /**
     * Test of loytyySolmu method, of class TrieSolmu.
     */
    @Test
    public void testLoytyySolmu() {
        System.out.println("loytyySolmu");
        ts.lisaaSolmu(2);
        assertEquals(true, ts.loytyySolmu(2));
    }

    @Test
    public void testPrinttaaTiedot() {
        System.out.println("printtaaTiedot");
        ts.lisaaSolmu(40);
        ts.printtaaTiedot();
        assertEquals("Solmu 1 johon on lisätty 1 painoa", ts.toString());
        assertEquals("Solmun alasolmut ovat: 40", ts.solmunTiedot());
    }

}
