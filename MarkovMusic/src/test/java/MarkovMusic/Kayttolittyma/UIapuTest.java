/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic.Kayttolittyma;

import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class UIapuTest {
    private UIapu uiapu;
    private Tiedostonlukija tl;
    
    public UIapuTest() {
        this.uiapu = new UIapu();
        this.tl = new Tiedostonlukija();
    }
    
    @Before
    public void setUp() {
    }
    
    /**
     * Test of komennot method, of class UIapu.
     */
    @Test
    public void testKomennot() {
        System.out.println("komennot");
        
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        
        assertEquals(komennot, uiapu.komennot());
    }

    /**
     * Test of kappaleet method, of class UIapu.
     */
    @Test
    public void testKappaleet() throws Exception {
        System.out.println("kappaleet");
        assertEquals(tl.listaaTiedostot("musiikki/kappaleet/"), uiapu.kappaleet());
    }

    /**
     * Test of sointutiedostot method, of class UIapu.
     */
    @Test
    public void testSointutiedostot() throws Exception {
        System.out.println("sointutiedostot");
        
        assertEquals(tl.listaaTiedostot("musiikki/sointutiedostot/"), uiapu.sointutiedostot());
    }

    /**
     * Test of midit method, of class UIapu.
     */
    @Test
    public void testMidit() throws Exception {
        System.out.println("midit");
        ArrayList<String> mid = new ArrayList<>();
        mid.add("bach-inventions.mid");
        assertEquals(mid, uiapu.midit());
    }

//    /**
//     * Test of muodostaBigramit method, of class UIapu.
//     */
//    @Test
//    public void testMuodostaBigramit() {
//        System.out.println("muodostaBigramit");
//        List<List<String>> syote = null;
//        UIapu instance = new UIapu();
//        Map<Bigram, Double> expResult = null;
//        Map<Bigram, Double> result = instance.muodostaBigramit(syote);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bigramApu2 method, of class UIapu.
//     */
//    @Test
//    public void testBigramApu2() {
//        System.out.println("bigramApu2");
//        List<List<Bigram>> bigramit = null;
//        UIapu instance = new UIapu();
//        Map<Bigram, Double> expResult = null;
//        Map<Bigram, Double> result = instance.bigramApu2(bigramit);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bigramApu1 method, of class UIapu.
//     */
//    @Test
//    public void testBigramApu1() {
//        System.out.println("bigramApu1");
//        List<List<String>> syote = null;
//        List<String> tekstit = new ArrayList<>()
//        UIapu instance = new UIapu();
//        List<List<Bigram>> expResult = null;
//        List<List<Bigram>> result = instance.bigramApu1(syote);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of bigramitSolmuiksi method, of class UIapu.
//     */
//    @Test
//    public void testBigramitSolmuiksi() {
//        System.out.println("bigramitSolmuiksi");
//        Map<Bigram, Double> bigramMap = null;
//        Trie juuri = null;
//        UIapu instance = new UIapu();
//        Trie expResult = null;
//        Trie result = instance.bigramitSolmuiksi(bigramMap, juuri);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
