package MarkovMusic.Apumetodit;

/**
 *
 * @author tompp
 */
public class MIDItiedot {

    private final long ajankohta;
    private final int savel;
    private final long kesto;

    /**
     * Miditiedot olion luomismetodi
     *
     * @param ajankohta ajankohta milloin MIDI event tapahtui
     * @param savel MIDI eventin sävelkorkeus
     * @param kesto MIDI eventin kesto (NOTE_OFF - NOTE_ON ajanhetket)
     */
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        final MIDItiedot other = (MIDItiedot) obj;
        if (this.ajankohta != other.ajankohta) {
            return false;
        }
        if (this.savel != other.savel) {
            return false;
        }
        if (this.kesto != other.kesto) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.ajankohta ^ (this.ajankohta >>> 32));
        hash = 23 * hash + this.savel;
        hash = 23 * hash + (int) (this.kesto ^ (this.kesto >>> 32));
        return hash;
    }

}
