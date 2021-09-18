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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    @Before
    public void setUp() {
        tl = new Tiedostonlukija();
        testiSijainti = "musiikki/sointutiedostot/testitiedosto.txt";
        testiTeksti = "a a a b b b";
        List<String> oletettuLista = new ArrayList<>();
        Collections.addAll(oletettuLista, "a", "a", "a", "b", "b", "b");
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Testaa metodia lataaNuotitTekstista luokka: Tiedostonlukija.
//     */
//    @Test
//    public void testLataaNuotitTekstista() throws Exception {
//        System.out.println("lataaNuotitTekstista");
//        String kappale = "testi";
//        List<String> tulos = tl.lataaNuotitTekstista(kappale);
//        assertEquals(oletettuLista, tulos);
//    }
   
    /**
     * Testaa metodia tekstiNuoteiksi, luokka: Tiedostonlukija
     */
    @Test
    public void testTekstiNuoteiksi() {
        List<String> oletetut = new ArrayList<>();
        Collections.addAll(oletetut, "a", "a", "a", "b", "b", "b");
        List<String> testattavat = tl.tekstiNuoteiksi(testiTeksti);
        assertEquals(oletetut, testattavat);
    }
    
    /**
     * Testaa metodia lueTiedosto, luokka: Tiedostonlukija
     */
    @Test
    public void testLueTiedosto() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(testiSijainti)));
        String oletettu = "";
        String rivi;
        while(true) {
            rivi = br.readLine();
            if (rivi == null) {
                break;
            }
            oletettu = oletettu.concat(rivi);
        }
        assertEquals(oletettu, tl.lueTiedosto(testiSijainti));
    }
}
