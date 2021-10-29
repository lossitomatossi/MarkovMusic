package MarkovMusic.Tietorakenteet;

import MarkovMusic.Apumetodit.MIDItiedot;
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

//    @Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

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
     * Test of syvyysOikein method, of class Trie.
     */
    @Test
    public void testSyvyysOikein() {
        System.out.println("syvyysOikein");
        Trie instance = new Trie();
        Boolean expResult = null;
        Boolean result = instance.syvyysOikein();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisaaTaulukkoTriehen method, of class Trie.
     */
    @Test
    public void testLisaaTaulukkoTriehen() {
        System.out.println("lisaaTaulukkoTriehen");
        int[] lista = null;
        Trie instance = new Trie();
        instance.lisaaTaulukkoTriehen(lista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of etsiJonoa method, of class Trie.
     */
    @Test
    public void testEtsiJonoa() {
        System.out.println("etsiJonoa");
        int[] jono = null;
        Trie instance = new Trie();
        boolean expResult = false;
        boolean result = instance.etsiJonoa(jono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisaaMiditiedotTriehen method, of class Trie.
     */
    @Test
    public void testLisaaMiditiedotTriehen() {
        System.out.println("lisaaMiditiedotTriehen");
        List<MIDItiedot> lista = null;
        int syvyys = 0;
        Trie instance = new Trie();
        instance.lisaaMiditiedotTriehen(lista, syvyys);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arvoAloitusArvot method, of class Trie.
     */
    @Test
    public void testArvoAloitusArvot() {
        System.out.println("arvoAloitusArvot");
        Trie instance = new Trie(3);
        int[] oletettu = new int[3];
        oletettu[0] = 1;
        int[] tulos = instance.arvoAloitusArvot();
        assertEquals(oletettu.length, tulos.length);
    }
}
