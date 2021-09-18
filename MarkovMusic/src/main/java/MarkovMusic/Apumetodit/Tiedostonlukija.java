package MarkovMusic.Apumetodit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tompp
 */
public class Tiedostonlukija {
    

    public Tiedostonlukija() {
    }
    
    public String lataaNuotitTekstista(String kappale) throws IOException {
        //tee monipuolinen metodi
        return this.lueTiedosto("musiikki/sointutiedostot/Wonderwall.txt");
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
