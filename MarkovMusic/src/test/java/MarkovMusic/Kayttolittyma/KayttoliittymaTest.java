package MarkovMusic.Kayttolittyma;

import MarkovMusic.Apumetodit.Tiedostonlukija;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
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

//    @Test
//    public void testaaMarkovinKetjunLuonti() throws Exception {
//        Scanner lukija = new Scanner("2\n2\npoistu");
//        Kayttoliittyma k = new Kayttoliittyma(lukija);
//        k.kaynnistaKayttoliittyma();
//        String[] tulosteet = tuloste.toString().split("\n");
//        assertEquals(true, tulosteet[2].startsWith("Valitse"));
//    }
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
        assertEquals(true, k.soitin.sequencerPyorii());
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
    public void testListaus() throws Exception {
        System.out.println("listaus");
        String kansio = "";
        Kayttoliittyma k = new Kayttoliittyma();
        List<String> expResult = null;
        List<String> result = k.listaus(kansio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void listaaValitut() throws Exception {
        System.out.println("listaa valitut");
        Scanner lukija = new Scanner("soita\npoistu");
        Kayttoliittyma k = new Kayttoliittyma(lukija);
        k.listaaValitut();
        String[] tulosteet = tuloste.toString().split("\n");
        assertEquals(true, tulosteet[1].startsWith("Valitut"));
//        assertEquals(" ", tulosteet[2]);
    }

}
