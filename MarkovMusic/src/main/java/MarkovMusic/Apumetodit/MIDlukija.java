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

    /**
     * MIDI tiedostoissa käytetty arvo sille onko kyseinen event äänen alku.
     */
    public static final int NOTE_ON = 0x90;

    /**
     * MIDI tiedostoissa käytetty arvo sille onko kyseinen event äänen loppu.*
     */
    public static final int NOTE_OFF = 0x80;

    /**
     * Taulukko jota käytetään äänenkorkeuden nuoteiksi kääntämiseen.
     */
    public static final String[] NOTE_NAMES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    /**
     * Muodostaa uuden MIDlukija olion.
     */
    public MIDlukija() {
    }

    /**
     * Metodi joka palauttaa Listan MIDItiedot olio listoja, jossa jokainen
     * lista sisältää yksittäisen Track:in nuottitiedot.
     *
     * @param tiedostonNimi Tiedosto jonka kaikki MIDItiedot halutaan
     * @return Palauttaa Listan MIDItiedot olio listoja
     * @throws InvalidMidiDataException Heittää virheen jos MIDI tiedoston
     * sisältämä data on virheellistä.
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy.
     */
    public List<List<MIDItiedot>> lueMIDI(String tiedostonNimi) throws InvalidMidiDataException, IOException {
        List<List<MIDItiedot>> kappaleenTiedot = new ArrayList<>();
        Sequence sequence = MidiSystem.getSequence(new File("musiikki/MID/" + tiedostonNimi));

        for (Track kappale : sequence.getTracks()) {
            kappaleenTiedot.add(raidanTiedot(kappale));

        }
//        System.out.println("kappaleen listojen maara" + kappaleenTiedot.size());
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

    /**
     * Metodi jolla saa MIDI tiedoston yksittäisen raidan tiedot
     *
     * @param tiedostonNimi Mikä tiedosto on kyseessä
     * @param raita Monesko raita pitäisi lukea
     * @return Palauttaa tyhjän listan jos raitaa ei ole tai MIDItiedot listan
     * @throws InvalidMidiDataException Heittää virheen jos MIDI tiedoston
     * sisältämä data on virheellistä.
     * @throws IOException Heittää virheen jos IO operaatio estyy tai keskeytyy.
     */
    public List<MIDItiedot> lueMIDIRaita(String tiedostonNimi, int raita) throws InvalidMidiDataException, IOException {
        List<MIDItiedot> kappaleenTiedot = new ArrayList<>();
        Sequence sequence = MidiSystem.getSequence(new File("musiikki/MID/" + tiedostonNimi));
        int raidanNumero = 0;
        for (Track kappale : sequence.getTracks()) {
            if (raidanNumero == raita) {
                kappaleenTiedot = (raidanTiedot(kappale));
                break;
            } else {
                raidanNumero++;
            }
        }
        return kappaleenTiedot;
    }
}
