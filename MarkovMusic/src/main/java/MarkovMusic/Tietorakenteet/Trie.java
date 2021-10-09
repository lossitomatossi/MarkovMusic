package MarkovMusic.Tietorakenteet;

import MarkovMusic.Apumetodit.MIDItiedot;
import java.util.List;

/**
 *
 * @author tompp
 */
public class Trie {

    private final TrieSolmu juuri;

    /**
     * Trie luokka toteuttaa Markovin ketjujen toiminnot ja ylläpitämisen
     */
    public Trie() {
        this.juuri = new TrieSolmu();
    }

    /**
     * Metodi jolla voidaan sijoittaa minkä tahansa kokoisia taulukoita Markovin
     * ketjuun.
     *
     * @param lista kokonaislukuja sisältävä lista
     */
    public void lisaaTaulukkoTriehen(int[] lista) {
        int[] kopio = lista;

        TrieSolmu nykyinen = juuri;

        for (int luku : kopio) {

            if (nykyinen.palautaSolmu(luku) == null) {
                nykyinen.lisaaSolmu(luku);
            }

//            nykyinen.printtaaTiedot();
//            System.out.println(" ");
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

            if (j == syvyys) {
                lisaaTaulukkoTriehen(lisattavat);
                j = 0;
            }
            System.out.println("J on: " + j + ", i on: " + i);
            lisattavat[j++] = lista.get(i).getSavel();
        }
        if (jakojaannos > 0) {
            lisaaLoputMidit(lista, apuIndeksi, j, syvyys);
        }
    }

    private void lisaaLoputMidit(List<MIDItiedot> lista, int apuIndeksi, int j, int syvyys) {
        int koko = lista.size();
        int jakojaannos = koko % syvyys;
        if (j == syvyys) {
            System.out.println("Nollataan välissä");
            j = 0;
        }
        int[] lisattavat2 = new int[jakojaannos + 1];
        for (int i = apuIndeksi; i < koko; i++) {
            System.out.println("J on: " + j + " i on: " + i);
            lisattavat2[j++] = lista.get(i).getSavel();
        }
        lisaaTaulukkoTriehen(lisattavat2);
    }
}
