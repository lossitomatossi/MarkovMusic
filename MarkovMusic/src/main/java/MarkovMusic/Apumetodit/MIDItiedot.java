package MarkovMusic.Apumetodit;

/**
 *
 * @author tompp
 */
public class MIDItiedot {
    private final int ajankohta;
    private final int savel;
    private final int kesto;

    public MIDItiedot(int ajankohta, int savel, int kesto) {
        this.ajankohta = ajankohta;
        this.savel = savel;
        this.kesto = kesto;
    }

    public int getAjankohta() {
        return ajankohta;
    }

    public int getKesto() {
        return kesto;
    }

    public int getSavel() {
        return savel;
    }

    @Override
    public String toString() {
        return "@" + ajankohta + " savel " + savel + " nuotin kesto " + kesto;
    }
    
    
    
}
