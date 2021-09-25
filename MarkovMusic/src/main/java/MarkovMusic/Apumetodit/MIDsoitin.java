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
    private Sequencer sequencer;

    public MIDsoitin() throws MidiUnavailableException {
        this.sequencer = MidiSystem.getSequencer();
    }
    
    public void soitaMid() throws MidiUnavailableException, FileNotFoundException, IOException, InvalidMidiDataException {
        sequencer.open();
        File tiedosto = new File("musiikki/MID/bach-inventions.mid");
        InputStream input = new BufferedInputStream(new FileInputStream(tiedosto));
        
        sequencer.setSequence(input);
        sequencer.start();
    }
    
    public void stop() {
        sequencer.stop();
        sulje();
    }
    
    public void sulje() {
        if (sequencer.isOpen()) {
            sequencer.close();
        }
    }
}
