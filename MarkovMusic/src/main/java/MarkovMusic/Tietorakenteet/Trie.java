package MarkovMusic.Tietorakenteet;

/**
 *
 * @author tompp
 */
public class Trie {

    private final TrieSolmu juuri;

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

    public boolean etsiJonoa(int[] jono) {
        TrieSolmu nykyinen = juuri;

        for (int i = 0; i < jono.length; i++) {
            nykyinen = nykyinen.palautaSolmu(jono[i]);

            if (nykyinen == null) {
                return false;
            }
        }

        return true;
    }
}
