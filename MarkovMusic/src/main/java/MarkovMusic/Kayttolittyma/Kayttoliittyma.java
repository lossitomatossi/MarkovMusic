package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */

import MarkovMusic.Algoritmit.ParinMuodostaja;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kayttoliittyma {
    //private final kappaleet();
    private final BufferedReader br;
    private final Tiedostonlukija tl;
    private final List<List<String>> kappaleet;
    private final ParinMuodostaja pm;
    private final UIapu uiapu;
    private Map<Bigram, Double> bigramMap;
    private Trie juuri;
    
    
    public Kayttoliittyma() {
        br = new BufferedReader(new InputStreamReader(System.in));
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        pm = new ParinMuodostaja();
        uiapu = new UIapu();
        bigramMap = new HashMap();
        juuri = new Trie();
    }
    
    public void kaynnistaKayttoliittyma() throws IOException {
        System.out.println("Tervetuloa MarkovMusic ohjelmaan!");
        String komento;
        while (true) {
            List<String> komennot = new ArrayList();
            System.out.println("Anna komento (jos haluat nähdä komennot kirjoita komennot):");
            komento = br.readLine();
            komento = komento.toLowerCase();
            switch (komento) {
                case "poistu":
                    System.out.println("Suljetaan Markov music...");
                    br.close();
                    return;
                case "komennot":
                    uiapu.komennot();
                    break;
                case "kappaleet":
                    uiapu.kappaleet();
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
                        case "k" -> {
                            bigramMap = uiapu.muodostaBigramit(kappaleet);
                            System.out.println("Bigram parit muodostettu!");
                        //System.out.println(bigramMap);
                            uiapu.bigramitSolmuiksi(bigramMap, juuri);
                    }
                        case "e" -> {
                            System.out.println("Palataan käyttöliittymään.");
                    }
                        default -> System.out.println("Komentoa " + komento + "ei tunnistettu. Valitse K tai E.");
                    }
                    break;

                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }
    
    }
    
}
