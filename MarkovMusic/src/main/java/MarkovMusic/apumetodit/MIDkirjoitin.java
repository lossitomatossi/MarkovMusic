package MarkovMusic.apumetodit;

import MarkovMusic.Apumetodit.MIDItiedot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.midi.*;

/**
 * 
 * @author tompp
 */
public class MIDkirjoitin {

    /** Koska projektin tarkoituksena ei ollut toteuttaa tiedostojen tallennusta, käytettiin mallina Karl Brownin esimerkkiä osoitteessa 
    http://www.automatic-pilot.com/midifile.html
    **/

    private String tiedostoNimi;

    /**
     * Luo MIDIkirjoittimen joka tallentaa halutun nimisen tiedoston
     * @param tiedostoNimi
     */
    public MIDkirjoitin(String tiedostoNimi) {
        this.tiedostoNimi = tiedostoNimi;
    }

    /**
     * Luo oletus MIDkirjoittimen
     */
    public MIDkirjoitin() {
        this.tiedostoNimi = "oletus.mid";
    }

    /**
     * Metodi joka toteuttaa tiedoston luomisen ja tallentamisen
     * @param nuotit lista äänenkorkeuksia
     * @param ajoitus lista ajanhetkiä
     * @throws InvalidMidiDataException MIDIdata virheellinen
     * @throws IOException IO ei saatavilla
     */
    public void tallennaMidi(ArrayList<Integer> nuotit, ArrayList<MIDItiedot> ajoitus) throws InvalidMidiDataException, IOException {
        Sequence s = new Sequence(javax.sound.midi.Sequence.PPQ, 24);

        Track t = s.createTrack();
        byte[] b = {(byte) 0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte) 0xF7};
        SysexMessage sm = new SysexMessage();
        sm.setMessage(b, 6);
        MidiEvent me = new MidiEvent(sm, (long) 0);
        t.add(me);

        MetaMessage mt = new MetaMessage();
//        byte[] bt = {0x02, (byte) 0x00, 0x00};
//        mt.setMessage(0x51, bt, 3);
//        me = new MidiEvent(mt, (long) 0);
//        t.add(me);

        // omni
        ShortMessage mm = new ShortMessage();
        mm.setMessage(0xB0, 0x7D, 0x00);
        me = new MidiEvent(mm, (long) 0);
        t.add(me);

        //****  set poly on  ****
        mm = new ShortMessage();
        mm.setMessage(0xB0, 0x7F, 0x00);
        me = new MidiEvent(mm, (long) 0);
        t.add(me);

        //****  set instrument to Piano  ****
        mm = new ShortMessage();
        mm.setMessage(0xC0, 0x00, 0x00);
        me = new MidiEvent(mm, (long) 0);
        t.add(me);
        int lyhyempi = Math.min(nuotit.size(), ajoitus.size());
        int ajankohta = 0;
        for (int i = 0; i < lyhyempi; i++) {
            //NOTE ON
            ajankohta += 1;
            mm = new ShortMessage();
            mm.setMessage(0x90, nuotit.get(i), 0x60);
            me = new MidiEvent(mm, ajankohta);
            t.add(me);
            ajankohta += ajoitus.get(i).getKesto();
            //NOTE OFF
            mm = new ShortMessage();
            mm.setMessage(0x80, nuotit.get(i), 0x40);
            me = new MidiEvent(mm, ajankohta);
            t.add(me);
        }

        //set end of track (meta event) 19 ticks later  ****
        mt = new MetaMessage();
        byte[] bet = {}; // empty array
        mt.setMessage(0x2F, bet, 0);
        me = new MidiEvent(mt, (long) 140);
        t.add(me);

        File f = new File(tiedostoNimi + ".mid");
        MidiSystem.write(s, 1, f);
    }

}
