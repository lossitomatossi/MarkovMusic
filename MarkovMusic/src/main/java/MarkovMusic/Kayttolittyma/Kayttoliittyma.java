package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */
import MarkovMusic.Apumetodit.MIDItiedot;
import MarkovMusic.Apumetodit.MIDlukija;
import MarkovMusic.Apumetodit.MIDsoitin;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Kayttoliittyma {

    //private final kappaleet();
    private final Tiedostonlukija tl;
    private final List<List<String>> kappaleet;
    private Map<Bigram, Double> bigramMap;
    private Trie juuri;
    private MIDsoitin soitin;
    private MIDlukija MIDlukija;
    private List<String> valitutMidit;
    private Scanner lukija;

    public Kayttoliittyma() throws MidiUnavailableException {
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        bigramMap = new HashMap();
        juuri = new Trie();
        soitin = new MIDsoitin();
        MIDlukija = new MIDlukija();
        valitutMidit = new ArrayList<>();
        lukija = new Scanner(System.in);
    }

    public Kayttoliittyma(Scanner lukija) throws MidiUnavailableException {
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        bigramMap = new HashMap();
        juuri = new Trie();
        soitin = new MIDsoitin();
        MIDlukija = new MIDlukija();
        valitutMidit = new ArrayList<>();
        this.lukija = lukija;
    }

    public void kaynnistaKayttoliittyma() throws IOException, MidiUnavailableException, FileNotFoundException, InvalidMidiDataException {
        System.out.println("Tervetuloa MarkovMusic ohjelmaan!");
        String komento;
        while (true) {
            System.out.println("Anna komento (jos haluat nähdä komennot kirjoita komennot):");
            komento = lukija.nextLine();
            komento = komento.toLowerCase();
            switch (komento) {
                case "1":
                    System.out.println("1. Valitse MIDI tiedosto(t) Markovin ketjua varten");
                    valitseMIDIt();
                    listaaValitut();
                    break;
                case "2":
                    valitseSyvyys();
                    luoMarkovinKetju();
                    break;
                case "3":
                    System.out.println("Haluatko samat ajoitukset nuoteille vai generoidaanko uudet?");
                    break;
                case "poistu":
                    System.out.println("Suljetaan");
                    soitin.sulje();
                    return;
                case "komennot":
                    System.out.println(komennot());
                    break;
                case "soita":
                    soitin.soitaMid();
                    break;
                case "stop":
                    soitin.stop();
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }

    }

    public void luoMarkovinKetju() {
        List<MIDItiedot> miditiedot = new ArrayList<>();
        juuri.lisaaMiditiedotTriehen(miditiedot, juuri.getSyvyys());
    }

    /**
     * Metodi joka listaa ohjelman komennot (ei toteutettu)
     *
     * @return String muuttuja joka sisältää ohjelman komennot.
     */
    public String komennot() {
        String komennot = "Ohjelman komennot: \n\n"
                + "eka komento \n"
                + "toka komento \n";
        return komennot;
    }

    /**
     * Metodi jolla listataan kansion kappaleet sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> kappaleet() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/kappaleet/");
    }

    /**
     * Metodi jolla listataan kansion sointutiedostot sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> sointutiedostot() throws IOException {
        System.out.println("Ohjelman löytämät kappaleet ovat:");
        return tl.listaaTiedostot("musiikki/sointutiedostot/");
    }

    /**
     * Metodi jolla listataan kansion MID sisältö
     *
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> midit() throws IOException {
        System.out.println("Ohjelman löytämät MID-tiedostot ovat:");
        return tl.listaaTiedostot("musiikki/MID/");
    }

    private void valitseMIDIt() throws IOException {
        System.out.println("Aloitetaan tiedostojen valinta Markovin"
                + " ketjuja varten.");
        List<String> midienNimet = midit();
        for (int i = 0; i < midienNimet.size(); i++) {
            System.out.println(i + ". " + midienNimet.get(i));
        }
        System.out.println("Montako kappaletta haluat valita?"
                + " Saman tiedoston voi valita useammin kuin kerran");
        int montako = Integer.parseInt(lukija.nextLine());
        int indeksi;
        System.out.println("Valitse MIDIen indeksit");
        for (int i = 0; i < montako; i++) {
            indeksi = Integer.parseInt(lukija.nextLine());
            if (indeksi > midienNimet.size() - 1) {
                System.out.println("Indeksi on liian suuri! "
                        + "Kokeile uudelleen");
                i--;
            } else {
                valitutMidit.add(midienNimet.get(indeksi));
            }
        }
    }

    private void listaaValitut() {
        System.out.println("Valitut MIDI tiedostot:");
        System.out.println(valitutMidit);
    }

    private void valitseSyvyys() {
        System.out.println("Valitse syvyys (syvyyden pitää olla suurempi kuin 1 ja pienempi kuin 7)");
        int syvyys = lukija.nextInt();
        if (!juuri.syvyysOikein()) {
            if (syvyys < 2 || syvyys > 6) {
                System.out.println("Syvyys ei ole välillä 2-6, syötä uusi syvyys tältä väliltä.");
                syvyys = lukija.nextInt();
            }
            juuri.setSyvyys(syvyys);
        }
    }

}
