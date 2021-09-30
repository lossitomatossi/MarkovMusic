package MarkovMusic.Apumetodit;

/**
 *
 * @author tompp
 */
public class MIDItiedot {

    private final long ajankohta;
    private final int savel;
    private final long kesto;

    public MIDItiedot(long ajankohta, int savel, long kesto) {
        this.ajankohta = ajankohta;
        this.savel = savel;
        this.kesto = kesto;
    }

    public long getAjankohta() {
        return ajankohta;
    }

    public long getKesto() {
        return kesto;
    }

    public int getSavel() {
        return savel;
    }

    @Override
    public String toString() {
        return "ajankohta: " + ajankohta + " savel: " + savel + " kesto: " + kesto;
    }
}
