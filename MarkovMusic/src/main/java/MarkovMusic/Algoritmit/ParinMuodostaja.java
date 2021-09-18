package MarkovMusic.Algoritmit;

import MarkovMusic.Tietorakenteet.Bigram;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tompp
 */
public class ParinMuodostaja {

    public ParinMuodostaja() {
    }

    public List<Bigram> muodostaTaajuusParit(List<Integer> taajuudet) {
        List<Bigram> parit = new ArrayList<Bigram>();
        //List<Integer> taajuus = taajuudet;
        for (int i = 1; i < taajuudet.size(); i++) {
            parit.add(new Bigram(taajuudet.get(i - 1), taajuudet.get(i)));
        }

        return parit;
    }

    public List<Bigram> muodostaNuottiParit(List<String> nuotit) {
        List<Bigram> parit = new ArrayList<Bigram>();
        for (int i = 1; i < nuotit.size(); i++) {
            parit.add(new Bigram(nuotit.get(i - 1), nuotit.get(i)));
        }

        return parit;
    }

}
