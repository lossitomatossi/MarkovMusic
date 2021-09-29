package MarkovMusic.Apumetodit;

/**
 *
 * @author tompp
 */
public class MIDItiedot {
    private final long ajankohta;
    private final int savel;
    private final int kesto;

    public MIDItiedot(long ajankohta, int savel, int kesto) {
        this.ajankohta = ajankohta;
        this.savel = savel;
        this.kesto = kesto;
    }

    public long getAjankohta() {
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
