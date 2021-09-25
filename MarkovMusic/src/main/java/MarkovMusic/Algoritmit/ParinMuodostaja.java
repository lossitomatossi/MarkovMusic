package MarkovMusic.Algoritmit;

import MarkovMusic.Tietorakenteet.Bigram;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author tompp
 */
public class ParinMuodostaja {

    public ParinMuodostaja() {
    }

    public List<Bigram> muodostaTaajuusParit(List<Integer> taajuudet) {
        List<Bigram> parit = new ArrayList<>();
        //List<Integer> taajuus = taajuudet;
        for (int i = 1; i < taajuudet.size(); i++) {
            parit.add(new Bigram(taajuudet.get(i - 1), taajuudet.get(i)));
        }

        return parit;
    }

    public List<Bigram> muodostaNuottiParit(List<String> nuotit) {
        List<Bigram> parit = new ArrayList<>();
        for (int i = 1; i < nuotit.size(); i++) {
            parit.add(new Bigram(nuotit.get(i - 1), nuotit.get(i)));
        }

        return parit;
    }
    
    public Map<Bigram, Double> summaaNuottiParit(List<Bigram> lista) {
        Map<Bigram, Long> summat = lista.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Bigram, Double> dSummat = new HashMap<>();
        for (Bigram b : summat.keySet()) {
            dSummat.put(b, summat.get(b).doubleValue());
        }
        return dSummat;
    }
}
