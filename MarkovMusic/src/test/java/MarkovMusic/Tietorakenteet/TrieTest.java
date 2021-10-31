package MarkovMusic.Tietorakenteet;

import MarkovMusic.Apumetodit.MIDItiedot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class TrieTest {

    public TrieTest() {
    }

    /**
     * Test of setSyvyys method, of class Trie.
     */
    @Test
    public void testSetSyvyys() {
        System.out.println("setSyvyys");
        int syvyys = 7;
        Trie instance = new Trie();
        assertEquals(0, instance.getSyvyys());
        instance.setSyvyys(syvyys);
        assertEquals(7, instance.getSyvyys());
    }

    /**
     * Test of lisaaTaulukkoTriehen method, of class Trie.
     */
    @Test
    public void testLisaaTaulukkoTriehen() {
        System.out.println("lisaaTaulukkoTriehen");
        int[] jono = new int[3];
        jono[0] = 1; jono[1] = 2; jono[2] = 3;
        Trie t = new Trie();
        TrieSolmu juuri = t.getJuuri();
        assertEquals(null, juuri.palautaSolmu(77));
        t.lisaaTaulukkoTriehen(jono);
        assertNotEquals(null, juuri.palautaSolmu(1));
    }

    /**
     * Test of etsiJonoa method, of class Trie.
     */
    @Test
    public void testEtsiJonoa() {
        System.out.println("etsiJonoa");
        int[] jono = new int[3];
        jono[0] = 1; jono[1] = 2; jono[2] = 3; 
        Trie t = new Trie();
        boolean tulos = t.etsiJonoa(jono);
        assertEquals(false, tulos);
        t.lisaaTaulukkoTriehen(jono);
        tulos = t.etsiJonoa(jono);
        assertEquals(true, tulos);
    }

    /**
     * Test of lisaaMiditiedotTriehen method, of class Trie.
     */
    @Test
    public void testLisaaMiditiedotTriehen() {
        System.out.println("lisaaMiditiedotTriehen");
        List<MIDItiedot> lista = new ArrayList<>();
        MIDItiedot eka = new MIDItiedot(0, 0, 30);
        MIDItiedot toka = new MIDItiedot(1, 1, 30);
        MIDItiedot kolmas = new MIDItiedot(2, 2, 30);
        MIDItiedot neljas = new MIDItiedot(3, 3, 30);
        MIDItiedot viides = new MIDItiedot(4, 4, 30);
        Collections.addAll(lista, eka, toka, kolmas, neljas, viides);
        int syvyys = 2;
        Trie t = new Trie();
        t.lisaaMiditiedotTriehen(lista, syvyys);
        int[] jono = {2,3};
        assertEquals(true, t.etsiJonoa(jono));
    }

    /**
     * Test of arvoAloitusArvot method, of class Trie.
     */
    @Test
    public void testArvoAloitusArvot() {
        System.out.println("arvoAloitusArvot");
        Trie t = new Trie(3);
        int[] oletettu = {1,2,3};
        t.lisaaTaulukkoTriehen(oletettu);
        oletettu[0] = 1;
        assertEquals(2, t.arvoAloitusArvot().length);
    }
    
    @Test
    public void testSeuraava() {
        System.out.println("seuraava");
        Trie t = new Trie(3);
        int[] oletettu = {1,2,3};
        int[] testi = {1,2};
        t.lisaaTaulukkoTriehen(oletettu);
        
        assertEquals(3, t.seuraava(testi));
    }
    
    @Test
    public void testLuoUutta() {
        Trie t = new Trie(3);
        int[] oletettu = {1,2,3};
        t.lisaaTaulukkoTriehen(oletettu);
        
        assertNotEquals(true, t.luoUutta(8).isEmpty());
    }
    @Test
    public void testLuoUutta2() {
        Trie t = new Trie(3);
        int[] oletettu = {1,2,3};
        t.lisaaTaulukkoTriehen(oletettu);
        
        assertEquals(true, t.luoUutta(2).isEmpty());
    }
    @Test
    public void testLuoUutta3() {
        Trie t = new Trie(3);
        int[] oletettu = {1, 2, 3};
        t.lisaaTaulukkoTriehen(oletettu);

        assertEquals(true, t.luoUutta(6).size()<=6);
    }
    
    @Test
    public void testLuoUutta4() {
        Trie t = new Trie(2);
        int[] oletettu = {1, 2, 3};
        t.lisaaTaulukkoTriehen(oletettu);

        assertEquals(true, t.luoUutta(7).size()<=7);
    }
}
