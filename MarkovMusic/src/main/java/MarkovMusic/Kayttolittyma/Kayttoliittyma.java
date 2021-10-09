package MarkovMusic.Kayttolittyma;

/**
 *
 * @author tompp
 */
import MarkovMusic.Algoritmit.ParinMuodostaja;
import MarkovMusic.Apumetodit.MIDItiedot;
import MarkovMusic.Apumetodit.MIDlukija;
import MarkovMusic.Apumetodit.MIDsoitin;
import MarkovMusic.Apumetodit.Tiedostonlukija;
import MarkovMusic.Tietorakenteet.Bigram;
import MarkovMusic.Tietorakenteet.Trie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class Kayttoliittyma {

    //private final kappaleet();
    private final BufferedReader br;
    private final Tiedostonlukija tl;
    private final List<List<String>> kappaleet;
    private final ParinMuodostaja pm;
    private final UIapu uiapu;
    private Map<Bigram, Double> bigramMap;
    private Trie juuri;
    private MIDsoitin soitin;
    private MIDlukija MIDlukija;

    public Kayttoliittyma() throws MidiUnavailableException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tl = new Tiedostonlukija();
        kappaleet = new ArrayList<>();
        pm = new ParinMuodostaja();
        uiapu = new UIapu();
        bigramMap = new HashMap();
        juuri = new Trie();
        soitin = new MIDsoitin();
        MIDlukija = new MIDlukija();
    }

    public void kaynnistaKayttoliittyma() throws IOException, MidiUnavailableException, FileNotFoundException, InvalidMidiDataException {
        System.out.println("Tervetuloa MarkovMusic ohjelmaan!");
        String komento;
        while (true) {
            List<String> komennot = new ArrayList();
            System.out.println("Anna komento (jos haluat nähdä komennot kirjoita komennot):");
            komento = br.readLine();
            komento = komento.toLowerCase();
            switch (komento) {
                case "poistu":
                    System.out.println("Suljetaan Markov music...");
                    br.close();
                    soitin.sulje();
                    return;
                case "komennot":
                    System.out.println(uiapu.komennot());
                    break;
                case "kappaleet":
                    System.out.println(uiapu.kappaleet());
                    break;
                case "sointutiedostot":
                    System.out.println(uiapu.sointutiedostot());
                    break;
                case "MIDIT":
                    System.out.println(uiapu.midit());
                    break;
                case "soita":
                    soitin.soitaMid();
                    break;
                case "stop":
                    soitin.stop();
                case "lue":
                    //listaa luettavat tiedostot
                    System.out.println("Valitse tiedosto");
                    //komento = br.readLine();
                    //komento = komento.toLowerCase();
                    List<String> wonderwall = tl.lataaNuotitTekstista("Wonderwall");
                    kappaleet.add(wonderwall);
                    break;
                case "bigram":
                    System.out.println("Olet valinnut " + kappaleet.size() + " kappaletta. Haluatko tehda niista bigram parit? (K/E)");
                    komento = br.readLine();
                    komento = komento.toLowerCase();
                    switch (komento) {
                        case "k" -> {
                            bigramMap = uiapu.muodostaBigramit(kappaleet);
                            System.out.println("Bigram parit muodostettu!");
                            //System.out.println(bigramMap);
                            uiapu.bigramitSolmuiksi(bigramMap, juuri);
                        }
                        case "e" -> {
                            System.out.println("Palataan käyttöliittymään.");
                        }
                        default ->
                            System.out.println("Komentoa " + komento + "ei tunnistettu. Valitse K tai E.");
                    }
                    break;
                case "t": //testausmetodi
//                    List<List<MIDItiedot>> tiedot = MIDlukija.lueMID("musiikki/MID/bach-inventions.mid");
                    List<List<MIDItiedot>> tiedot = MIDlukija.lueMID();
                    System.out.println("Taikaprint");
                    for (List<MIDItiedot> raita : tiedot) {
                        System.out.println(raita.size());
                        System.out.println("\n");
                    }
                    System.out.println(tiedot.get(1).get(1));
                    break;
                case "m": //testausmetodi
                    Trie t = new Trie();
                    int[] lista = new int[3];
                    lista[0] = 1;
                    lista[1] = 3;
                    lista[2] = 6;
                    t.lisaaTaulukkoTriehen(lista);

                    int[] lista2 = new int[3];
                    lista2[0] = 1;
                    lista2[1] = 3;
                    lista2[2] = 2;
                    t.lisaaTaulukkoTriehen(lista2);

                    lista2[0] = 2;
                    lista2[1] = 2;
                    lista2[2] = 2;
//                    t.lisaaTaulukkoTriehen(lista2);
                    System.out.println(t.etsiJonoa(lista2));
                    System.out.println(t.etsiJonoa(lista));
                    int[] lista3 = new int[2];
                    lista3[0] = 1;
                    lista3[1] = 3;
                    System.out.println(t.etsiJonoa(lista3));

                    break;
                case "n":
                    MIDItiedot eka = new MIDItiedot(0, 3, 5);
                    MIDItiedot toka = new MIDItiedot(0, 4, 7);
                    MIDItiedot kolmas = new MIDItiedot(0, 8, 3);
                    MIDItiedot neljas = new MIDItiedot(0, 3, 3);
                    MIDItiedot viides = new MIDItiedot(0, 4, 3);
                    MIDItiedot kuudes = new MIDItiedot(0, 4, 3);

                    List<MIDItiedot> midit = new ArrayList<>();
                    Collections.addAll(midit, eka, toka, kolmas, neljas, viides, kuudes);
                    Trie testiT = new Trie();
                    testiT.lisaaMiditiedotTriehen(midit, 3);
                    break;
                case "b":
                    eka = new MIDItiedot(0, 3, 5);
                    toka = new MIDItiedot(0, 4, 7);
                    kolmas = new MIDItiedot(0, 8, 3);
                    neljas = new MIDItiedot(0, 3, 3);
                    viides = new MIDItiedot(0, 4, 3);
                    kuudes = new MIDItiedot(0, 4, 3);
                    MIDItiedot seiska = new MIDItiedot(0, 4, 3);

                    midit = new ArrayList<>();
                    Collections.addAll(midit, eka, toka, kolmas, neljas, viides, kuudes, seiska);
                    testiT = new Trie();
                    testiT.lisaaMiditiedotTriehen(midit, 4);
                    break;
                default:
                    System.out.println("Komentoa " + komento + " ei ole olemassa.\n"
                            + "Valitse " + "\"komennot\"" + " nahdaksesi komennot.");
            }
        }

    }

}
