package MarkovMusic.Kayttolittyma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author tompp
 */
public class KayttoliittymaTest {

    private final ByteArrayOutputStream tuloste = new ByteArrayOutputStream();

    @Before
    public void setUp() throws MidiUnavailableException {
        System.setOut(new PrintStream(tuloste));

    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
//    @Test
//    public void testKaynnistaKayttoliittyma() throws Exception {
//        System.out.println("kaynnistaKayttoliittyma");
//        Kayttoliittyma instance = new Kayttoliittyma();
//        instance.kaynnistaKayttoliittyma();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testaaPoistu() throws Exception {
        Scanner lukija = new Scanner("poistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Suljetaan"));
    }

    @Test
    public void testaaMarkovinKetjunLuonti() throws Exception {
        Scanner lukija = new Scanner("markov\n1\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Monennenko"));
    }

    @Test
    public void testaaVaaraSyote() throws Exception {
        Scanner lukija = new Scanner("vaara\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Komentoa vaara"));
    }

}
