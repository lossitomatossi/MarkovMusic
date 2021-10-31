package MarkovMusic.Kayttolittyma;

import MarkovMusic.Apumetodit.Tiedostonlukija;
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
    private final Tiedostonlukija tl = new Tiedostonlukija();

    @Before
    public void setUp() throws MidiUnavailableException {
        System.setOut(new PrintStream(tuloste));

    }

    @Test
    public void testaaPoistu() throws Exception {
        Scanner lukija = new Scanner("poistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Suljetaan"));
    }

    @Test
    public void testaaVaaraSyote() throws Exception {
        Scanner lukija = new Scanner("vaara\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Komentoa vaara"));
    }

    /**
     * Test of komennot method, of class Kayttoliittyma.
     */
    @Test
    public void testKomennot() throws Exception {
        System.out.println("komennot");
        Scanner lukija = new Scanner("komennot\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        assertEquals(komennot, k.komennot());
    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyote1() throws Exception {
        System.out.println("syote 1");
        Scanner lukija = new Scanner("1\n0\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tervetuloa"));

    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyote2() throws Exception {
        System.out.println("syote 2");
        Scanner lukija = new Scanner("2\n2\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[3].startsWith("Valitse"));
    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyote3() throws Exception {
        System.out.println("syote 3");
        Scanner lukija = new Scanner("3\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[3].startsWith("Haluatko"));
    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyote4() throws Exception {
        System.out.println("syote 4");
        Scanner lukija = new Scanner("1\n1\n0\n2\n2\n4\ntiedosto\n100\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tervetuloa"));

//        assertEquals(true, tulosteet[3].startsWith("Minkä"));
//        assertEquals(true, tulosteet[4].startsWith("Kuinka"));
    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyoteStop() throws Exception {
        System.out.println("syote stop");
        Scanner lukija = new Scanner("stop\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        assertEquals(false, k.soitin.sequencerPyorii());
    }

    /**
     * Test of luoMarkovinKetju method, of class Kayttoliittyma.
     */
    @Test
    public void testLuoMarkovinKetju() throws Exception {
        System.out.println("luoMarkovinKetju");
        Scanner lukija = new Scanner("1\n1\n0\n2\n2\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();

    }

    /**
     * Test of listaus method, of class Kayttoliittyma.
     */
    @Test
    public void testListaus() throws Exception, MidiUnavailableException, MidiUnavailableException, MidiUnavailableException {
        System.out.println("listaus");
        Scanner lukija = new Scanner("jotain");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.listaus("kappaleet");
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tätä"));
    }

    /**
     * Test of listaus method, of class Kayttoliittyma.
     */
    @Test
    public void testListaus2() throws Exception, MidiUnavailableException, MidiUnavailableException, MidiUnavailableException {
        System.out.println("listaus2");
        Scanner lukija = new Scanner("jotain");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.listaus("ei olemassa");
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Kansion"));
    }

    /**
     * Test of listaus method, of class Kayttoliittyma.
     */
    @Test
    public void testListaus3() throws Exception, MidiUnavailableException, MidiUnavailableException, MidiUnavailableException {
        System.out.println("listaus3");
        Scanner lukija = new Scanner("jotain");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.listaus("midit");
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Ohjelman"));
    }

    @Test
    public void testListaaValitut() throws Exception {
        System.out.println("listaa valitut");
        Scanner lukija = new Scanner("soita\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.listaaValitut();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Valitut"));
    }

    /**
     * Test of valitseMIDIt method, of class Kayttoliittyma.
     */
    @Test
    public void testValitseMIDIt() throws Exception {
        System.out.println("valitseMIDIt");
        Scanner lukija = new Scanner("0");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.valitseMIDIt();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Aloitetaan"));
        assertEquals(true, tulosteet[2].startsWith("Montako"));
    }

    /**
     * Test of valitseSyvyys method, of class Kayttoliittyma.
     */
    @Test
    public void testValitseSyvyys() throws Exception {
        System.out.println("syvyys liian suuri");
        Scanner lukija = new Scanner("9\n9");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.valitseSyvyys();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Valitse"));
        assertEquals(true, tulosteet[2].startsWith("Syvyys"));
    }

    @Test
    public void testValitseSyvyys2() throws Exception {
        System.out.println("syvyys liian pieni");
        Scanner lukija = new Scanner("0\n0");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.valitseSyvyys();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Valitse"));
        assertEquals(true, tulosteet[2].startsWith("Syvyys"));
    }

    /**
     * Test of soitaKappale method, of class Kayttoliittyma.
     */
    @Test
    public void testSoitaKappale() throws Exception {
        System.out.println("soitaKappale");
        Scanner lukija = new Scanner("soita\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.soitaKappale();
        assertEquals(true, k.soitin.sequencerAuki());
        assertEquals(true, k.soitin.sequencerPyorii());
    }

    /**
     * Test of soitaKappale method, of class Kayttoliittyma.
     */
    @Test
    public void testSoitaKappale2() throws Exception {
        System.out.println("soitaKappale2");
        Scanner lukija = new Scanner("soita\nkappale\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tervetuloa"));
        assertEquals(true, tulosteet[3].startsWith("Minkä"));

    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testMidiValintoja() throws Exception {
        System.out.println("midivalintoja");
        Scanner lukija = new Scanner("1\n2\n0\n0\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tervetuloa"));
    }

    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testMidiValintoja2() throws Exception {
        System.out.println("midivalintoja2");
        Scanner lukija = new Scanner("1\n2\n0\n8\n8\n0\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Tervetuloa"));
    }
}
