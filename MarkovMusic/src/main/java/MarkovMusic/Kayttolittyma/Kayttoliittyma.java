package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */
import MarkovMusic.Apumetodit.MIDItiedot;
import MarkovMusic.Apumetodit.MIDlukija;
import MarkovMusic.Apumetodit.MIDsoitin;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Trie;
import MarkovMusic.apumetodit.MIDkirjoitin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.sound.midi.MidiUnavailableException;

public class Kayttoliittyma {

    //private final kappaleet();
    private final Tiedostonlukija tl;
    private final List<List<String>> kappaleet;
    private final Trie juuri;
    MIDsoitin soitin;
    private final MIDlukija MIDlukija;
    private List<String> valitutMidit;
    private final Scanner lukija;
    private ArrayList<Integer> tuotetutNuotit;

    public Kayttoliittyma(Scanner lukija) throws MidiUnavailableException {
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        juuri = new Trie();
        soitin = new MIDsoitin();
        MIDlukija = new MIDlukija();
        valitutMidit = new ArrayList<>();
        tuotetutNuotit = new ArrayList<>();
        this.lukija = lukija;
    }

    public void kaynnistaKayttoliittyma() throws Exception {
        System.out.println("Tervetuloa MarkovMusic ohjelmaan!");
        String komento;
        int[] taulukko = {8, 7, 4, 4, 4};
        juuri.muutaTaulukko(taulukko, 6);
        juuri.seuraava(taulukko);

        while (true) {
            System.out.println("Anna komento (jos haluat nähdä komennot kirjoita komennot):");
            komento = lukija.nextLine();
            komento = komento.toLowerCase();
            switch (komento) {
                case "1":
                    System.out.println("Valitse MIDI tiedosto(t) Markovin ketjua varten");
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
                case "4":
//                    System.out.println(Arrays.toString(juuri.arvoAloitusArvot()));
                    System.out.println("Minkä haluat tiedoston nimeksi?");
                    String kappale = lukija.nextLine();
                    System.out.println("Kuinka monta nuottia pitkän kappaleen maksimissaan haluat? ");
                    int montako = lukija.nextInt();
                    teeMusiikkia(kappale, montako);
                    break;
                case "poistu":
                    System.out.println("Suljetaan");
                    soitin.sulje();
                    return;
                case "komennot":
                    System.out.println(komennot());
                    break;
                case "soita":
                    soitaKappale();
                    break;
                case "stop":
                    soitin.stop();
                    break;
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }

    }

    public void luoMarkovinKetju() throws Exception {
        if (valitutMidit.isEmpty()) {
            System.out.println("Markovin ketjua ei voi luoda ilman dataa");
        } else {
            for (String midi : valitutMidit) {
                juuri.lisaaMiditiedotTriehen(MIDlukija.lueMIDIRaita(midi, 1), juuri.getSyvyys());
            }
        }
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
     * Metodi jolla listataan halutun kansion sisältö. Käytössä olemassaolevien
     * MIDI tiedostojen esittämiseen käyttäjälle.
     *
     * @param kansio Kansion nimi jonka sisältö halutaan listata.
     * @return Palauttaa Listan String olioita jotka ovat tiedostojen nimiä.
     * @throws IOException Heittää virheen jos sijaintia ei ole olemassa.
     */
    public List<String> listaus(String kansio) throws IOException {
        switch (kansio) {
            case "midit" -> {
                System.out.println("Ohjelman löytämät MIDI tiedostot ovat:");
                return tl.listaaTiedostot("musiikki/MID/");
            }
            case "kappaleet", "sointutiedostot" ->
                System.out.println("Tätä toimintoa ei ole vielä toteutettu");
            default ->
                System.out.println("Kansion " + kansio + " sisällön tulostamista"
                        + "ei tueta");
        }
        return null;
    }

    public void valitseMIDIt() throws IOException {
        System.out.println("Aloitetaan tiedostojen valinta Markovin"
                + " ketjuja varten.");
        System.out.println("Montako kappaletta haluat valita?"
                + " Saman tiedoston voi valita useammin kuin kerran");
        int montako = Integer.parseInt(lukija.nextLine());
        List<String> midienNimet = listaus("midit");
        for (int i = 0; i < midienNimet.size(); i++) {
            System.out.println(i + ". " + midienNimet.get(i));
        }
        System.out.println("Valitse MIDIen indeksit");
        for (int i = 0; i < montako; i++) {
            valitseMidi(midienNimet);
        }
    }

    public void valitseMidi(List<String> midit) {
        int maksimiIndeksi = midit.size();
        int indeksi;
        while (true) {
            indeksi = Integer.parseInt(lukija.nextLine());
            if (indeksi > maksimiIndeksi - 1) {
                System.out.println("Indeksi on liian suuri! "
                        + "Kokeile uudelleen");
            } else {
                break;
            }
        }
        valitutMidit.add(midit.get(indeksi));

    }

    public void listaaValitut() {
        System.out.println("Valitut MIDI tiedostot:");
        System.out.println(valitutMidit);
    }

    public void valitseSyvyys() {
        System.out.println("Valitse syvyys (syvyyden pitää olla suurempi kuin 1 ja pienempi kuin 7)");
        int syvyys = lukija.nextInt();
        if (syvyys < 2 || syvyys > 6) {
            System.out.println("Syvyys ei ole välillä 2-6, syötä uusi syvyys tältä väliltä.");
            syvyys = lukija.nextInt();
        }
        juuri.setSyvyys(syvyys);

    }

    public void soitaKappale() throws Exception {
        System.out.println("Minkä kappaleen haluat soittaa.");
        String kappale = lukija.nextLine();
        soitin.soitaMid();
    }

    private void teeMusiikkia(String kappale, int montako) throws Exception {

        MIDkirjoitin mk = new MIDkirjoitin(kappale);

        tuotetutNuotit = juuri.luoUutta(montako);
        mk.tallennaMidi(tuotetutNuotit, (ArrayList<MIDItiedot>) MIDlukija.lueMIDIRaita(valitutMidit.get(0), 1));
        System.out.println("Tallennettu kappale: " + kappale);
    }

}
