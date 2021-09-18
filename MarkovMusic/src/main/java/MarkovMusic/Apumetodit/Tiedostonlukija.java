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
    

    public Tiedostonlukija() {
        nuottiRegex = "[a-zA-Z0-9]+";
    }
    
    public List<String> lataaNuotitTekstista(String kappale) throws IOException {
        //tee monipuolinen metodi
        String teksti = this.lueTiedosto("musiikki/sointutiedostot/Wonderwall.txt");
        return tekstiNuoteiksi(teksti);
    }
    
    private List<String> tekstiNuoteiksi(String kappale) {
        List<String> kaikkiNuotit = new ArrayList<>();
        Matcher m = Pattern.compile(nuottiRegex).matcher(kappale);
        while (m.find()) {
            kaikkiNuotit.add(m.group());
        }
        return kaikkiNuotit;
    }
    
    private String lueTiedosto(String sijainti) throws FileNotFoundException, IOException {
        File tiedosto = new File(sijainti);
        BufferedReader br = new BufferedReader(new FileReader(tiedosto));
        String teksti = "";
        String rivi;
        while(true) {
            rivi = br.readLine();
            if (rivi == null) {
                break;
            }
            teksti = teksti.concat(rivi);
        }
        
        return teksti;
    }
}
