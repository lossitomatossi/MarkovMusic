package MarkovMusic.Apumetodit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 *
 * @author tompp
 */
public class MIDlukija {
    public static final int NOTE_ON = 0x90;
    public static final int NOTE_OFF = 0x80;
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public MIDlukija() {
    }
    

    public List<MIDItiedot> lueMID(String MID, int kanava) throws InvalidMidiDataException, IOException {
        List<MIDItiedot> tiedot = new ArrayList<>();
        Sequence sequence = MidiSystem.getSequence(new File("musiikki/MID/bach-inventions.mid"));

        Track kappale = sequence.getTracks()[0];
        
        for (int i = 0; i < kappale.size() - 1; i++) {
            MidiEvent tapahtuma = kappale.get(i);
            MidiMessage viesti = tapahtuma.getMessage();
            if (viesti instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) viesti;
                MIDItiedot apu = new MIDItiedot(tapahtuma.getTick(), 0, i);
            }
            
            
//            tiedot.add()
        }
        

        
        return tiedot;

    }
}
