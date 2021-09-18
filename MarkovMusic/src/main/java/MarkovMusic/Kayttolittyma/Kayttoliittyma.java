package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */

import MarkovMusic.Apumetodit.Tiedostonlukija;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Kayttoliittyma {
    //private final kappaleet();
    private final BufferedReader br;
    private final Tiedostonlukija tl;
    private List<String> kappaleet;
    
    public Kayttoliittyma() {
        br = new BufferedReader(new InputStreamReader(System.in));
        tl = new Tiedostonlukija();
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
                    String wonderwall = tl.lataaNuotitTekstista("Wonderwall");
                    kappaleet.add(wonderwall);
                    break;
                case "bigram":
                    break;
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }
    
    }
    
}
