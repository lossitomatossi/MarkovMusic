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

    public List<List<MIDItiedot>> lueMID(String MID) throws InvalidMidiDataException, IOException {
        List<List<MIDItiedot>> kappaleenTiedot = new ArrayList<>();
        Sequence sequence = MidiSystem.getSequence(new File("musiikki/MID/bach-inventions.mid"));

        for (Track kappale : sequence.getTracks()) {
            kappaleenTiedot.add(raidanTiedot(kappale));

        }
        System.out.println("kappaleen listojen maara" + kappaleenTiedot.size());
        return kappaleenTiedot;
    }

    private List<MIDItiedot> raidanTiedot(Track raita) {
        List<MIDItiedot> tiedot = new ArrayList<>();
        for (int i = 1; i < raita.size() - 1; i += 2) {
            MidiEvent tapahtuma = raita.get(i);
            MidiMessage viesti = tapahtuma.getMessage();
            Long alkuhetki = tapahtuma.getTick();
            Long loppuhetki = raita.get(i + 1).getTick();
            if (viesti instanceof ShortMessage sm) {
                MIDItiedot apu = new MIDItiedot(alkuhetki, sm.getData1(), loppuhetki - alkuhetki);
                System.out.println(apu);
                tiedot.add(apu);
                System.out.println(tiedot.size());
            }
        }
        return tiedot;
    }
}
