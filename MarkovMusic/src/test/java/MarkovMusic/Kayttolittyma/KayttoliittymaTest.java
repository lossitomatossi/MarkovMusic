package MarkovMusic.Kayttolittyma;

import MarkovMusic.Apumetodit.Tiedostonlukija;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
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

//    /**
//     * Test of kappaleet method, of class UIapu.
//     */
//    @Test
//    public void testKappaleet() throws Exception {
//        System.out.println("kappaleet");
//        Scanner lukija = new Scanner("komennot\npoistu");
//        Kayttoliittyma k = new Kayttoliittyma(lukija);
//        assertEquals(tl.listaaTiedostot("musiikki/kappaleet/"), k.kappaleet());
//    }
//    /**
//     * Test of sointutiedostot method, of class UIapu.
//     */
//    @Test
//    public void testSointutiedostot() throws Exception {
//        System.out.println("sointutiedostot");
//        Scanner lukija = new Scanner("komennot\npoistu");
//        Kayttoliittyma k = new Kayttoliittyma(lukija);
//        assertEquals(tl.listaaTiedostot("musiikki/sointutiedostot/"), k.sointutiedostot());
//    }
//
//    /**
//     * Test of midit method, of class UIapu.
//     */
//    @Test
//    public void testMidit() throws Exception {
//        Scanner lukija = new Scanner("midit\npoistu");
//        Kayttoliittyma k = new Kayttoliittyma(lukija);
//        ArrayList<String> mid = new ArrayList<>();
//        mid.add("bach-inventions.mid");
//        assertEquals(mid, k.midit());
//    }
    /**
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyote1() throws Exception {
        System.out.println("syote 1");
        Scanner lukija = new Scanner("1\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[2].startsWith("Valitse"));
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
        assertEquals(true, tulosteet[2].startsWith("Valitse"));
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
        assertEquals(true, tulosteet[2].startsWith("Haluatko"));
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
     * Test of kaynnistaKayttoliittyma method, of class Kayttoliittyma.
     */
    @Test
    public void testSyoteSoita() throws Exception {
        System.out.println("syote soita");
        Scanner lukija = new Scanner("soita\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.kaynnistaKayttoliittyma();
        assertEquals(true, k.soitin.sequencerAuki());
    }

    /**
     * Test of luoMarkovinKetju method, of class Kayttoliittyma.
     */
    @Test
    public void testLuoMarkovinKetju() throws Exception {
        System.out.println("luoMarkovinKetju");
        Kayttoliittyma instance = new Kayttoliittyma();
        instance.luoMarkovinKetju();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Kayttoliittyma instance = new Kayttoliittyma();
        instance.valitseMIDIt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valitseSyvyys method, of class Kayttoliittyma.
     */
    @Test
    public void testValitseSyvyys() throws Exception {
        System.out.println("syvyys liian suuri");
        Scanner lukija = new Scanner("8\n8");
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
        Scanner lukija = new Scanner("soita\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.soitaKappale();
        assertEquals(true, k.soitin.sequencerAuki());
    }
}
