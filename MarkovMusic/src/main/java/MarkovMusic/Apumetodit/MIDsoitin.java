package MarkovMusic.Apumetodit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 *
 * @author tompp
 */
public class MIDsoitin {

    private final Sequencer sequencer;

    /**
     * Metodi jolla MIDI tiedostojen toistaminen on mahdollista.
     *
     * @throws MidiUnavailableException Heittää virheen jos
     * MidiSystem.getSequencer() ei ole käytettävissä.
     */
    public MIDsoitin() throws MidiUnavailableException {
        this.sequencer = MidiSystem.getSequencer();
        sequencer.open();
    }

    /**
     * Metodi MIDI tiedostojen soittamiseen.
     *
     * @throws MidiUnavailableException Heittää virheen jos
     * MidiSystem.getSequencer() ei ole käytettävissä.
     * @throws FileNotFoundException Heittää virheen jos tiedostoa ei löydy.
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy
     * @throws InvalidMidiDataException Heittää virheen jos MIDI tiedoston
     * sisältämä data on virheellistä.
     */
    public void soitaMid() throws MidiUnavailableException, FileNotFoundException, IOException, InvalidMidiDataException {
        avaaSequencer();
        File tiedosto = new File("musiikki/MID/bach-inventions.mid");
        InputStream input = new BufferedInputStream(new FileInputStream(tiedosto));

        sequencer.setSequence(input);
        sequencer.start();
    }

    /**
     * Metodi joka pysäyttää sequencerin toiminnan.
     */
    public void stop() {
        sequencer.stop();
        sulje();
    }

    /**
     * Metodi joka sulkee sequencerin jos se on käynnissä.
     */
    public void sulje() {
        if (sequencer.isOpen()) {
            sequencer.close();
        }
    }

    /**
     * Metodi jolla voi tarkistaa soittimen sequencerin tilan.
     *
     * @return Palauttaa totuusarvon sequencerin avoimuudesta.
     */
    public Boolean sequencerAuki() {
        return this.sequencer.isOpen();
    }

    /**
     * Metodi jolla voi avata sequencerin/varmistaa että sequencer on auki.
     *
     * @throws MidiUnavailableException Heittää virheen jos
     * MidiSystem.getSequencer() ei ole käytettävissä.
     */
    public void avaaSequencer() throws MidiUnavailableException {
        if (!sequencerAuki()) {
            this.sequencer.open();
        }
    }

    /**
     * Metodi jolla voi tarkistaa sequencerista tiedon isRunning()
     *
     * @return Palauttaa isRunning() totuusarvon.
     */
    public Boolean sequencerPyorii() {
        return this.sequencer.isRunning();
    }
}
