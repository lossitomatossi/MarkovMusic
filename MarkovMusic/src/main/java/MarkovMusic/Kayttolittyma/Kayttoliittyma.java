package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */

import MarkovMusic.Algoritmit.ParinMuodostaja;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kayttoliittyma {
    //private final kappaleet();
    private final BufferedReader br;
    private final Tiedostonlukija tl;
    private List<List<String>> kappaleet;
    private List<List<Bigram>> bigramit;
    private ParinMuodostaja pm;
    
    
    public Kayttoliittyma() {
        br = new BufferedReader(new InputStreamReader(System.in));
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        bigramit = new ArrayList<>();
        pm = new ParinMuodostaja();
    }
    
    public void kaynnistaKayttoliittyma() throws IOException {
        System.out.println("Tervetuloa MarkovMusic ohjelmaan");
        String komento;
        while (true) {
            List<String> komennot = new ArrayList();
            
            // tee metodi joka listaa toiminnot
            System.out.println("Anna komento:");
            komento = br.readLine();
            komento = komento.toLowerCase();
            switch (komento) {
                case "poistu":
                    System.out.println("Suljetaan Markov music...");
                    br.close();
                    return;
                case "komennot":
                    //listaa komennot
                    break;
                case "kappaleet":
                    //nayta kappaleet
                    break;
                case "lue":
                    //listaa luettavat tiedostot
                    System.out.println("Valitse tiedosto");
                    //komento = br.readLine();
                    //komento = komento.toLowerCase();
                    List<String> wonderwall = tl.lataaNuotitTekstista("Wonderwall");
                    kappaleet.add(wonderwall);
                    break;
                case "bigram":
                    System.out.println("Olet valinnut " + kappaleet.size() + " kappaletta. Haluatko tehda niista bigram parit? (K/E)");
                    komento = br.readLine();
                    komento = komento.toLowerCase();
                    switch (komento) {
                        case "k":
                            for (List<String> kappale : kappaleet) {
                                bigramit.add(pm.muodostaNuottiParit(kappale));
                            }
                            System.out.println("Bigram parit muodostettu!");
                            //tee metodi joka muutta bigram parit uniikeiks ja laskee lukumäärät et saa todennäkösyydet.
                            for (List<Bigram> bigramLista : bigramit) {
                                pm.summaaNuottiParit(bigramLista);
                            }
                            break;
                        case "e":
                            break;
                        default:
                            System.out.println("Komentoa " + komento + "ei tunnistettu. Valitse K tai E.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }
    
    }
    
}
