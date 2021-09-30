package MarkovMusic.Apumetodit;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tompp
 */
public class MIDlukijaTest {

    Sequence sequence;
    List<Track> kappaleet;
    MIDlukija ml;
    List<List<MIDItiedot>> verrokki;

    public MIDlukijaTest() {
    }

    @Before
    public void setUp() throws InvalidMidiDataException, IOException {
        sequence = MidiSystem.getSequence(new File("musiikki/MID/bach-inventions.mid"));
        kappaleet = Arrays.asList(sequence.getTracks());
        ml =  new MIDlukija();
        verrokki = ml.lueMID();
    }

    /**
     * Test of lueMID method, of class MIDlukija.
     */
//    @Test
//    public void lueMID(String MID) throws Exception {
//        System.out.println("lueMID");
//        System.out.println(kappaleet.size());
//        System.out.println(verrokki.size());
//        assertEquals(kappaleet.size(),verrokki.size());
//
//    }

}
