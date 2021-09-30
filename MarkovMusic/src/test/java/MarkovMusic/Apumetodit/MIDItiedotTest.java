package MarkovMusic.Apumetodit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class MIDItiedotTest {
    private MIDItiedot oletus;
    private MIDItiedot vertailu1;
    private MIDItiedot vertailu2;
    
    public MIDItiedotTest() {
    }
    
    
    @Before
    public void setUp() {
        oletus = new MIDItiedot(0, 57, 1);
        vertailu1 = new MIDItiedot(0, 57, 1);
        vertailu2 = new MIDItiedot(200, 42, 30);
    }

    /**
     * Testaa kaikki getterit kerralla
     */
    @Test
    public void testGetterit() {
        System.out.println("getAjankohta");
        assertEquals(oletus.getAjankohta(), vertailu1.getAjankohta());
        assertEquals(oletus.getKesto(), vertailu1.getKesto());
        assertEquals(oletus.getSavel(), vertailu1.getSavel());
    }

    /**
     * Test of toString method, of class MIDItiedot.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("ajankohta: 0 savel: 57 kesto: 1", oletus.toString());
    }
    
}
