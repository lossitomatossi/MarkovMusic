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

    /**
     * Käyttöliittymän apumetodi joka erottelee sovelluslogiikkaa
     * käyttöliittymän ulkopuolelle.
     */
    public UIapu() {
        this.pm = new ParinMuodostaja();
        this.tl = new Tiedostonlukija();
    }

    /**
     * Metodi joka listaa ohjelman komennot (ei toteutettu)
     *
     * @return String muuttuja joka sisältää ohjelman komennot.
     */
    public String komennot() {
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        return komennot;
    }

    /**
     * Metodi jolla listataan kansion kappaleet sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> kappaleet() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/kappaleet/");
    }

    /**
     * Metodi jolla listataan kansion sointutiedostot sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> sointutiedostot() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/sointutiedostot/");
    }

    /**
     * Metodi jolla listataan kansion MID sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> midit() throws IOException {
        System.out.println("Ohjelman löytämät MID-tiedostot ovat:");
        return tl.listaaTiedostot("musiikki/MID/");
    }

    /**
     * Metodi joka muodostaa uniikit siirtymäparit (ei todennäköisesti
     * tarpeellinen)
     *
     * @param syote Lista String olio listoja, esimerkiksi usean tiedoston
     * listat.
     * @return Palauttaa Map<Bigram, Double> olion jossa on avaimena uniikki
     * siirtymä ja arvona siirtymän esiintymismäärä.
     */
    public Map<Bigram, Double> muodostaBigramit(List<List<String>> syote) {
        List<List<Bigram>> palautettava = bigramApu1(syote);

        return bigramApu2(palautettava);
    }

    /**
     * muodostaBigramit metodin apumetodi joka laskee uniikkien siirtymien
     * lukumäärät
     *
     * @param bigramit Lista Bigram olio listoja joille laskeminen toteutetaan.
     * @return Palauttaa Map<Bigram, Double> olion jossa on avaimena uniikki
     * siirtymä ja arvona siirtymän esiintymismäärä.
     */
    public Map<Bigram, Double> bigramApu2(List<List<Bigram>> bigramit) {
        Map<Bigram, Double> summat = new HashMap();
        bigramit.forEach((var bigramLista) -> {
            summat.putAll(pm.summaaNuottiParit(bigramLista));
        });
        return summat;
    }

    /**
     * muodostaBigramit metodin apumetodi joka muodostaa jokaisen listan
     * siirtymäparit
     *
     * @param syote Lista String olio listoja, esimerkiksi usean tiedoston
     * listat.
     * @return Palauttaa listan Bigram olio listoja.
     */
    public List<List<Bigram>> bigramApu1(List<List<String>> syote) {
        List<List<Bigram>> bigramit = new ArrayList<>();
        syote.forEach(kappale -> {
            bigramit.add(pm.muodostaNuottiParit(kappale));
        });
        return bigramit;
    }

    /**
     * Metodi joka lisää Trie muuttujaan Map<Bigram, Double> alkiot oikeilla
     * painoilla.
     *
     * @param bigramMap Map<Bigram, Double> jossa on avaimena uniikki siirtymä
     * ja arvona siirtymän esiintymismäärä.
     * @param juuri Trie tietorakenteen juurisolmu
     * @return Palauttaa Trie olion johon on lisätty alkiot.
     */
    public Trie bigramitSolmuiksi(Map<Bigram, Double> bigramMap, Trie juuri) {
//        List<Bigram> avaimet = (List<Bigram>) bigramMap.keySet();
        Trie palautusTrie = juuri;
        for (Bigram solmu : bigramMap.keySet()) {

        }

        return palautusTrie;
    }

}
