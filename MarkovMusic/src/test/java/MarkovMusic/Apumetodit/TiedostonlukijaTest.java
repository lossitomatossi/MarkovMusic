package MarkovMusic.Apumetodit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author tompp
 */
public class TiedostonlukijaTest {
    private Tiedostonlukija tl;
    private String testiSijainti;
    private String testiTeksti;
    private List<String> oletettuLista;
    
    public TiedostonlukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        tl = new Tiedostonlukija();
        testiSijainti = "musiikki/testikansio/testitiedosto.txt";
        testiTeksti = "Em A Em A Em A";
        oletettuLista = new ArrayList<>();
        Collections.addAll(oletettuLista, "Em", "A", "Em", "A", "Em", "A");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testaa metodia lataaNuotitTekstista luokka: Tiedostonlukija.
     */
    @Test
    public void testLataaNuotitTekstista() throws Exception {
        System.out.println("lataaNuotitTekstista");
        String kappale = "painotus";
        List<String> tulos = tl.lataaNuotitTekstista(kappale);
        assertEquals(oletettuLista, tulos);
    }
   
    /**
     * Testaa metodia tekstiNuoteiksi, luokka: Tiedostonlukija
     */
    @Test
    public void testTekstiNuoteiksi() {
        List<String> oletetut = new ArrayList<>();
        Collections.addAll(oletetut, "Em", "A", "Em", "A", "Em", "A");
        List<String> testattavat = tl.tekstiNuoteiksi(testiTeksti);
        assertEquals(oletetut, testattavat);
    }
    
    /**
     * Testaa metodia lueTiedosto, luokka: Tiedostonlukija
     */
    @Test
    public void testLueTiedosto() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(testiSijainti)));
        String oletettu = "a a a b b b ";
        
        assertEquals(oletettu, tl.lueTiedosto(testiSijainti));
    }

    /**
     * Test of listaaTiedostot method, of class Tiedostonlukija.
     */
    @Test
    public void testListaaTiedostot() throws Exception {
        System.out.println("listaaTiedostot");
        String sijainti = "musiikki/testikansio/testi2";
        tl.listaaTiedostot(sijainti);
        ArrayList<String> tyhja = new ArrayList<>();
        assertEquals(tyhja, tl.listaaTiedostot(sijainti));
    }
    
    @Test
    public void testListaaTiedostot2() throws Exception {
        System.out.println("listaaTiedostot");
        String sijainti = "musiikki/testikansio";
        tl.listaaTiedostot(sijainti);
        ArrayList<String> vertailu = new ArrayList<>();
        vertailu.add("testi2");
        vertailu.add("testitiedosto.txt");
        assertEquals(vertailu, tl.listaaTiedostot(sijainti));
    }
}
