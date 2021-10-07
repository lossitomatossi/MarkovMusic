package MarkovMusic.Tietorakenteet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tompp
 */
public class TrieSolmu {
    private final TrieSolmu[] solmut;
    private final int[] painot;
    private int yhteensa;
    Random r;
    int solmunArvo;
    

    public TrieSolmu(int arvo) {
        this.solmut = new TrieSolmu[128];
        this.painot = new int[128];
        this.yhteensa = 0;
        this.r = new Random();
        this.solmunArvo = arvo;
    }
    
        public TrieSolmu() {
        this.solmut = new TrieSolmu[128];
        this.painot = new int[128];
        this.yhteensa = 0;
        this.r = new Random();
        this.solmunArvo = -99;
    }
    
    public void lisaaSolmu(int x) {
        if (solmut[x] == null) {
            solmut[x] = new TrieSolmu(x);
        }
        this.yhteensa+=1;
        painot[x]++;
    }
    
    public int painojenLkm() {
        return yhteensa;
    }
    
    public int satunnaisluku() {
        return r.nextInt(yhteensa+1)-1;
    }
    
    private TrieSolmu valitse(int satunnaisluku) {
        int indeksi = 0;
        for (int i = 0; i < solmut.length-1; i++) {
            satunnaisluku -= painot[i];
            if (satunnaisluku <= 0) {
                indeksi = i;
                break;
            }
        }
        return solmut[indeksi];
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
    
    public TrieSolmu palautaSolmu(int solmu) {
        return solmut[solmu];
    }

    @Override
    public String toString() {
        return "Solmu " + solmunArvo + " johon on lisätty " 
                + this.yhteensa + " painoa";
    }
    
    private void printtaaSolmut() {
        System.out.print("Solmun alasolmut ovat: ");
        alaSolmut().forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println("");
    }
    
    public void poistaSolmu(int solmu) {
        this.yhteensa -= painot[solmu];
        painot[solmu] = 0;
        solmut[solmu] = null;
    }
    
    public ArrayList<Integer> alaSolmut() {
        ArrayList<Integer> palautettava = new ArrayList();
        for (TrieSolmu solmu : solmut) {
            if (solmu != null) {
                palautettava.add(solmu.solmunArvo);
            }
        }
        return palautettava;
    }
    
    public void printtaaTiedot() {
        System.out.println(toString());
        printtaaSolmut();
    }
    
    public boolean loytyySolmu(int arvo) {
        return solmut[arvo] == null;
    }
}
