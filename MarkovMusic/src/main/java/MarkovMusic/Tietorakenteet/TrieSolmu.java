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
    public void lisaaLapset(HashMap<String, Integer> lisattavat) {
        Integer esiintymia = 0;
        for (Integer lkm : lisattavat.values()) {
            esiintymia += lkm;
        }
        
        Double todnak = 0.0;
        Double edellisenTodnak = 0.0;
        Integer lkm;
        for (String nuotti : lisattavat.keySet()) {
            lkm = lisattavat.get(nuotti);
            todnak = edellisenTodnak + (lkm / esiintymia);
            this.lapset.put(todnak, nuotti);
        }
    }
    
    
    
}
