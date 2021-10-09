package MarkovMusic.Apumetodit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tompp
 */
public class Tiedostonlukija {

    String nuottiRegex;

    /**
     * Luokka jolla voidaan lukea tekstitiedostoja ja palauttaa niiden "sanat"
     * Listana String muuttujia.
     */
    public Tiedostonlukija() {
        nuottiRegex = "[a-zA-Z0-9]+";
    }

    /**
     * Metodi jolla tekstitiedostoon kirjoitetut nuotit/tabit voidaan muuttaa
     * listaksi String olioita jatkokäsittelyä varten.
     *
     * @param kappale halutun tiedoston nimi
     * @return Palauttaa Listan String muuttujia
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy
     */
    public List<String> lataaNuotitTekstista(String kappale) throws IOException {
        String sijainti = "musiikki/sointutiedostot/" + kappale + ".txt";
        String teksti = this.lueTiedosto(sijainti);

        return tekstiNuoteiksi(teksti);
    }

    /**
     * Metodi joka erottelee tiedostosta yksittäiset "sanat".
     *
     * @param kappale halutun tiedoston nimi
     * @return Palauttaa Listan String muuttujia
     */
    public List<String> tekstiNuoteiksi(String kappale) {
        List<String> kaikkiNuotit = new ArrayList<>();
        Matcher m = Pattern.compile(nuottiRegex).matcher(kappale);
        while (m.find()) {
            kaikkiNuotit.add(m.group());
        }

        return kaikkiNuotit;
    }

    /**
     * Metodi joka lukee tiedoston ja muodostaa sen sisällöstä yhden String
     * muuttujan jolle voidaan suorittaa Regex operaatioita jotka ovat nopeampia
     * kuin tavallinen String.split().
     *
     * @param sijainti Tiedoston sijainti
     * @return Palauttaa kaikista riveistä muodostetun String muuttujan.
     * @throws FileNotFoundException Heittää virheen jos tiedostoa ei löydy.
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy
     */
    public String lueTiedosto(String sijainti) throws FileNotFoundException, IOException {
        File tiedosto = new File(sijainti);
        BufferedReader br = new BufferedReader(new FileReader(tiedosto));
        String teksti = "";
        String rivi;
        while (true) {
            rivi = br.readLine();
            if (rivi == null) {
                break;
            }
            teksti = teksti.concat(rivi + " ");
        }

        return teksti;
    }

    /**
     * Metodi joka listaa halutun sijainnin kaikki tiedostot
     *
     * @param sijainti Sijainti jonka tiedostot halutaan listata
     * @return Palauttaa tekstitiedoston joka sisältää kaikkien muuttujien nimet
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy
     */
    public List<String> listaaTiedostot(String sijainti) throws IOException {
        File kansio = new File(sijainti);
        List<String> tiedostot = new ArrayList();
        for (File tiedosto : kansio.listFiles()) {
            tiedostot.add(tiedosto.getName());
        }

        return tiedostot;
    }
}
