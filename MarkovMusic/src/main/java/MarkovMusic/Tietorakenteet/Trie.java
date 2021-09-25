package MarkovMusic.Tietorakenteet;

import java.util.HashMap;

/**
 *
 * @author tompp
 */
public class Trie {
    private HashMap<String, TrieSolmu> juuri;

    public Trie() {
        this.juuri = new HashMap();
    }
}