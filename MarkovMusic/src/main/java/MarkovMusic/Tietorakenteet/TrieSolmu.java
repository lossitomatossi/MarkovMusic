package MarkovMusic.Tietorakenteet;

import java.util.Random;

/**
 *
 * @author tompp
 */
public class TrieSolmu {
    private final TrieSolmu[] lapset;
    private final int[] lukumaarat;
    private int yhteensa;
    Random r;

    public TrieSolmu() {
        this.lapset = new TrieSolmu[128];
        this.lukumaarat = new int[128];
        this.yhteensa = 0;
        this.r = new Random();
    }
    
    public void lisaaLapsi(int x) {
        
        if (lapset[x] == null) {
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
