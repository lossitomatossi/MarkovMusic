package MarkovMusic.Kayttolittyma;

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

    private Tiedostonlukija tl;

    /**
     * Käyttöliittymän apumetodi joka erottelee sovelluslogiikkaa
     * käyttöliittymän ulkopuolelle.
     */
    public UIapu() {
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
