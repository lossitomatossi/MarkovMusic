package MarkovMusic.Apumetodit;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class MIDlukijaTest {
    private MIDlukija ml;
    
    public MIDlukijaTest() {
    }
    
    @Before
    public void setUp() {
        ml = new MIDlukija();
    }

    /**
     * Test of lueMIDI method, of class MIDlukija.
     */
    @Test
    public void testLueMIDI() throws Exception {
        System.out.println("lueMIDI");
        String tiedostonNimi = "bach-inventions.mid";
        List<List<MIDItiedot>> lista = ml.lueMIDI(tiedostonNimi);
        assertEquals(4, lista.size());
    }

    /**
     * Test of lueMIDIRaita method, of class MIDlukija.
     */
    @Test
    public void testLueMIDIRaita() throws Exception {
        System.out.println("lueMIDIRaita");
        String tiedostonNimi = "bach-inventions.mid";
        List<List<MIDItiedot>> lista = ml.lueMIDI(tiedostonNimi);
        List<MIDItiedot> verrokki = ml.lueMIDIRaita(tiedostonNimi, 1);
        assertEquals(lista.get(1).get(0), verrokki.get(0));
        assertNotEquals(lista.get(2).get(0), verrokki.get(0));
    }
    
}
