package MarkovMusic.Tietorakenteet;

import java.util.HashMap;

/**
 *
 * @author tompp
 */
public class StringTrieSolmu implements TrieSolmu {
    private HashMap<Float, StringTrieSolmu> lapset;
    private String avain;

    public StringTrieSolmu(String avain) {
        this.avain = avain;
        this.lapset = new HashMap();
    }
    
    
    
}
