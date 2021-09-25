package MarkovMusic.Kayttolittyma;

import MarkovMusic.Algoritmit.ParinMuodostaja;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tompp
 */
public class UIapu {

    private ParinMuodostaja pm;

    public UIapu() {
        this.pm = new ParinMuodostaja();
    }

    public void komennot() {
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        System.out.println(komennot);
    }

    public void kappaleet() {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        List<String> kappaleet = new ArrayList();
        String printti = "";
        for (String biisi : kappaleet) {
            printti += biisi + "\n";
        }
        System.out.println(printti);
    }

    public Map<Bigram, Long> muodostaBigramit(List<List<String>> syote) {
        List<List<Bigram>> palautettava = bigramApu1(syote);
        
        return bigramApu2(palautettava);
    }

    public Map<Bigram, Long> bigramApu2(List<List<Bigram>> bigramit) {
        Map<Bigram, Long> summat = new HashMap();
        bigramit.forEach((var bigramLista) -> {
            summat.putAll(pm.summaaNuottiParit(bigramLista));
        });
        return summat;
    }
    
    public List<List<Bigram>> bigramApu1(List<List<String>> syote) {
        List<List<Bigram>> bigramit = new ArrayList<>();
        syote.forEach(kappale -> {
            bigramit.add(pm.muodostaNuottiParit(kappale));
        });
        return bigramit;
    }
    
    public Trie bigramitSolmuiksi(Map<Bigram, Long> bigramMap, Trie juuri) {
//        List<Bigram> avaimet = (List<Bigram>) bigramMap.keySet();
        Trie palautusTrie = juuri;
        for (Bigram solmu : bigramMap.keySet()) {
            
        }
        
        return palautusTrie;
    }

}
