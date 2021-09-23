package MarkovMusic.Kayttolittyma;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tompp
 */
public class UIapu {

    public UIapu() {
    }
    
    public void komennot() {
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        System.out.println(komennot);
    }
    
    public void kappaleet() {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        List<String> kappaleet = new ArrayList();
        String printti = "";
        for (String biisi : kappaleet) {
            printti += biisi + "\n";
        }
        System.out.println(printti);
        
    }
    
}
