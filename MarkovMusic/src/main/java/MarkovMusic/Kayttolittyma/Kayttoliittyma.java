package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayttoliittyma {
    //private final kappaleet();
    private final Scanner skanneri;
    private final BufferedReader br;
    
    public Kayttoliittyma() {
        skanneri = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        
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
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }
    
    }
    
}
