package MarkovMusic.Tietorakenteet;

/**
 *
 * @author tompp
 */
public class Trie {
    private TrieSolmu juuri;

    public Trie() {
        this.juuri = new TrieSolmu();
    }
    
    /**
     *
     * @param lista
     */
    public void lisaaTriehen(int[] lista) {
        int[] kopio = lista;
        
        TrieSolmu nykyinen = juuri;
        
        for (int luku : kopio) {
            
            if (nykyinen.palautaSolmu(luku) == null) {
                nykyinen.lisaaSolmu(luku);
            }
            
            nykyinen.printtaaTiedot();
            System.out.println(" ");
            nykyinen = nykyinen.palautaSolmu(luku);
        }
    }
}
