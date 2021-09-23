package MarkovMusic.Tietorakenteet;

import java.util.HashMap;

/**
 *
 * @author tompp
 */
public class TrieSolmu {
    private HashMap<Float, TrieSolmu> lapset;
    private String avain;

    public TrieSolmu(String avain) {
        this.avain = avain;
        this.lapset = new HashMap();
    }
    
    
    
}
