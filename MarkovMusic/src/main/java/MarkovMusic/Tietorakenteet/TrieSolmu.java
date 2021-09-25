package MarkovMusic.Tietorakenteet;

import java.util.HashMap;

/**
 *
 * @author tompp
 */
public class TrieSolmu {
    private HashMap<Double, String> lapset;
    private String avain;
    private Boolean numero;

    public TrieSolmu(String avain, Boolean onNumero) {
        this.avain = avain;
        this.lapset = new HashMap();
        this.numero = onNumero;
    }
    
    //ottaa vastaan kaikki lapset ja niiden esiintymislukumaarat
    public void lisaaLapset(HashMap<Bigram, Double> lisattavat) {
        double esiintymia = 0.0;
        for (Double lkm : lisattavat.values()) {
            esiintymia += lkm;
        }
        
        Double todnak = 0.0;
        Double edellisenTodnak = 0.0;
        Double lkm;
        for (Bigram b : lisattavat.keySet()) {
            lkm = lisattavat.get(b);
            todnak = edellisenTodnak + (lkm / esiintymia);
            this.lapset.put(todnak, b.s2);
        }
    }
    
    public HashMap<Double, String> getLapset() {
        return this.lapset;
    }
    
    
    
}
