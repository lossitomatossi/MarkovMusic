package MarkovMusic.Kayttolittyma;

import MarkovMusic.Algoritmit.ParinMuodostaja;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.io.IOException;
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
    private Tiedostonlukija tl;

    public UIapu() {
        this.pm = new ParinMuodostaja();
        this.tl = new Tiedostonlukija();
    }

    public String komennot() {
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        return komennot;
    }

    public List<String> kappaleet() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/kappaleet/");
    }

    public List<String> sointutiedostot() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/sointutiedostot/");
    }

    public List<String> midit() throws IOException {
        System.out.println("Ohjelman löytämät MID-tiedostot ovat:");
        return tl.listaaTiedostot("musiikki/MID/");
    }

    public Map<Bigram, Double> muodostaBigramit(List<List<String>> syote) {
        List<List<Bigram>> palautettava = bigramApu1(syote);

        return bigramApu2(palautettava);
    }

    public Map<Bigram, Double> bigramApu2(List<List<Bigram>> bigramit) {
        Map<Bigram, Double> summat = new HashMap();
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

    public Trie bigramitSolmuiksi(Map<Bigram, Double> bigramMap, Trie juuri) {
//        List<Bigram> avaimet = (List<Bigram>) bigramMap.keySet();
        Trie palautusTrie = juuri;
        for (Bigram solmu : bigramMap.keySet()) {

        }

        return palautusTrie;
    }

}
