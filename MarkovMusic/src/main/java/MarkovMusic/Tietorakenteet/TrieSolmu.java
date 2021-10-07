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
    
    public int lapsienLkm() {
        return yhteensa;
    }
    
    public int satunnaisluku() {
        return r.nextInt(yhteensa+1)-1;
    }
    
    private TrieSolmu valitse(int satunnaisluku) {
        int indeksi = 0;
        for (int i = 0; i < lapset.length-1; i++) {
            satunnaisluku -= lukumaarat[i];
            if (satunnaisluku <= 0) {
                indeksi = i;
                break;
            }
        }
        return lapset[indeksi];
    }
    
    public TrieSolmu valitseSolmu() {
        int x = satunnaisluku();
        if (yhteensa == 0) {
            return null;
        }
        else {
            return valitse(x);
        }
    }
}
