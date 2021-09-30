package MarkovMusic.Apumetodit;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tompp
 */
public class MIDsoitinTest {

    MIDsoitin mid;

    public MIDsoitinTest() {
    }

    @Before
    public void setUp() throws MidiUnavailableException {
        this.mid = new MIDsoitin();
    }

    /**
     * Test of soitaMid method, of class MIDsoitin.
     */
    @Test
    public void testSoitaJaStop() throws Exception {
        System.out.println("soitaMid");
        mid.soitaMid();
        assertEquals(true, mid.sequencerPyorii());
        mid.stop();
        assertEquals(false, mid.sequencerPyorii());
    }

    /**
     * Test of stop method, of class MIDsoitin.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        
    }

    /**
     * Test of sulje method, of class MIDsoitin.
     */
    @Test
    public void testSuljeJaAvaa() throws MidiUnavailableException {
        System.out.println("sulje ja avaa");
        mid.sulje();
        assertEquals(false, mid.sequencerAuki());
        mid.sulje();
        assertEquals(false, mid.sequencerAuki());
        mid.avaaSequencer();
        assertEquals(true, mid.sequencerAuki());
        mid.avaaSequencer();
        assertEquals(true, mid.sequencerAuki());
    }

}
