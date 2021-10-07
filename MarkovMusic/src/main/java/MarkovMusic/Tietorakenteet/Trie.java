package MarkovMusic.Tietorakenteet;

import java.util.Random;

/**
 *
 * @author tompp
 */
public class Trie {

    private final TrieSolmu[] lapset;
    private final int[] lukumaarat;
    private int yhteensa;
    private TrieSolmu apusolmu;
    Random r;

    public Trie() {
        this.lapset = new TrieSolmu[128];
        this.lukumaarat = new int[128];
        this.yhteensa = 0;
        this.apusolmu = new TrieSolmu();
        this.r = new Random();
    }

    public void lisaaLapsi(int x) {
        apusolmu = lapset[x];
        if (apusolmu == null) {
            lapset[x] = new TrieSolmu();
        }
        this.yhteensa++;
        lukumaarat[x]++;
    }
    
    public int juureenLisatty() {
        return yhteensa;
    }
    
    public int satunnaisluku() {
        return r.nextInt(yhteensa);
    }
    
    public TrieSolmu valitseSolmu() {
        int x = satunnaisluku();
        for (int i = 0; i < lapset.length; i++) {
            x -= lukumaarat[i];
            if (x <= 0) {
                return lapset[i];
            }
        }
        return null;
    }
}
