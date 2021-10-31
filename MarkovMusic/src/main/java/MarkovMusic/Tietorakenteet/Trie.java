package MarkovMusic.Tietorakenteet;

import MarkovMusic.Apumetodit.MIDItiedot;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tompp
 */
public class Trie {

    private final TrieSolmu juuri;
    private int syvyys;

    /**
     * Trie luokka toteuttaa Markovin ketjujen toiminnot ja ylläpitämisen
     */
    public Trie() {
        this.juuri = new TrieSolmu();
        this.syvyys = 0;
    }

    /**
     * Trie luokka toteuttaa Markovin ketjujen toiminnot ja ylläpitämisen
     *
     * @param syvyys Markovin ketjun syvyys
     */
    public Trie(int syvyys) {
        this.juuri = new TrieSolmu();
        this.syvyys = syvyys;
    }

    public void setSyvyys(int syvyys) {
        this.syvyys = syvyys;
    }

    public Boolean syvyysOikein() {
        return syvyys != 0;
    }

    public int getSyvyys() {
        if (syvyysOikein()) {
            return syvyys;
        }
        return 0;
    }

    /**
     * Metodi jolla voidaan sijoittaa minkä tahansa kokoisia taulukoita Markovin
     * ketjuun.
     *
     * @param lista kokonaislukuja sisältävä lista
     */
    public void lisaaTaulukkoTriehen(int[] lista) {
        TrieSolmu nykyinen = juuri;

        for (int luku : lista) {
            if (nykyinen.palautaSolmu(luku) == null) {
                nykyinen.lisaaSolmu(luku);
            }
            nykyinen = nykyinen.palautaSolmu(luku);
        }
    }

    /**
     * Metodi jolla voi tarkistaa löytyykö numerojono kokonaisuudessaan Trie
     * rakenteesta
     *
     * @param jono Etsittävä taulukko kokonaislukuja
     * @return Palauttaa totuusarvon jonon löytymisestä
     */
    public boolean etsiJonoa(int[] jono) {
        TrieSolmu nykyinen = juuri;

        for (int i = 0; i < jono.length; i++) {
            nykyinen = nykyinen.palautaSolmu(jono[i]);

            if (nykyinen == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi jolla voi lisätä MIDI tiedostosta saadut tiedot kerralla halun
     * syvyiseen Markovin ketjuun
     *
     * @param lista MIDItiedostoja sisältävä lista
     * @param syvyys Minkä syvyisen Markovin ketjun käyttäjä haluaa luoda
     */
    public void lisaaMiditiedotTriehen(List<MIDItiedot> lista, int syvyys) {
        int koko = lista.size();
        int jakojaannos = koko % syvyys;
        int apuIndeksi = koko - jakojaannos;

        System.out.println("Syvyys: " + syvyys + " listan koko: " + koko + " jakojaannos: "
                + jakojaannos + " apuIndeksi: " + apuIndeksi);
        int j = 0;
        int[] lisattavat = new int[syvyys];
        for (int i = 0; i < apuIndeksi; i++) {
//            System.out.println("J on: " + j + ", i on: " + i);
            lisattavat[j++] = lista.get(i).getSavel();
            if (j == syvyys) {
//                System.out.println(Arrays.toString(lisattavat));
                lisaaTaulukkoTriehen(lisattavat);
                j = 0;
            }
            
        }
    }

    /**
     * Metodi joka arpoo aloituskohdan Markovin ketjua varten, ns. ensimmaisen
     * arvon jolla ketjua aletaan kulkemaan.
     *
     */
    public int[] arvoAloitusArvot() {
        int[] aloitusArvot = new int[syvyys - 1];
        TrieSolmu ts = getJuuri();
        for (int i = 0; i < syvyys-1; i++) {
            System.out.println(ts.solmunTiedot());
            int satunnaisluku = ts.satunnaisluku();
            System.out.println("Satunnaisluku: " + satunnaisluku);
            ts = ts.valitse(satunnaisluku);
            aloitusArvot[i] = ts.solmunArvo;
        }
        return aloitusArvot;
    }
    
    public TrieSolmu getJuuri() {
        return this.juuri;
    }

}
