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
        List<Integer> taajuus = taajuudet;
        for (int i = 1; i < taajuus.size(); i++) {
            parit.add(new Bigram(taajuus.get(i - 1), taajuus.get(i)));
        }

        return parit;
    }

    public List<Bigram> muodostaNuottiParit(List<String> nuotit) {
        List<Bigram> parit = new ArrayList<Bigram>();

        return parit;
    }

}
