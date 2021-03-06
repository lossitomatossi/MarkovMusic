package MarkovMusic.Tietorakenteet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author tompp
 */
public class TrieSolmu {

    private final TrieSolmu[] solmut;
    private final ArrayList<Integer> painot;
    Random r;
    int solmunArvo = -99;

    /**
     * TrieSolmu on luokka joka toteuttaa Markovin ketjujen solmut
     *
     * @param i
     */
    public TrieSolmu(int arvo) {
        this.solmut = new TrieSolmu[128];
        this.painot = new ArrayList<>();
        this.r = new Random();
        this.solmunArvo = arvo;
    }

    /**
     * Parametriton muuttuja on käytössä Trien juurisolmujen luomiseksi
     */
    public TrieSolmu() {
        this.solmut = new TrieSolmu[128];
        this.painot = new ArrayList<>();
        this.r = new Random();
    }

    /**
     * Lisää tälle TrieSolmulle lapsen jos sitä ei ole vielä olemassa. Päivittää
     * myös taulukot joilla ylläpidetään jokaisen lapsen todennäköisyyksiä.
     *
     * @param x Lapsen arvo.
     */
    public void lisaaSolmu(int x) {
        if (solmut[x] == null) {
            solmut[x] = new TrieSolmu(x);
        }
        painot.add(x);
    }

    /**
     * Getteri yhteensa muuttujalle
     *
     * @return Kokonaisluku joka kertoo montako lasta on yritetty lisätä tälle
     * solmulle
     */
    public int painojenLkm() {
        return painot.size();
    }

    /**
     * Metodi todennäköisyyksien arpomiseen, eroteltu testauksen
     * varmentamiseksi.
     *
     * @return Palauttaa kokonaisluvun jota käytetään ketjun lasten valintaan.
     */
    public int satunnaisluku() {
        if (painot.isEmpty()) {
            return -1;
        }
        return r.nextInt(painojenLkm());
    }

    /**
     * Valitsee arpomalla jonkun arvoista
     * @param satunnaisluku arvontaan käytetty arvo
     * @return palauttaa solmun
     */
    public TrieSolmu valitse(int satunnaisluku) {
        Collections.sort(painot);
        int valittu = painot.get(satunnaisluku);
        return solmut[valittu];
    }

    /**
     * Metodi solmujen valitsemiseen.
     *
     * @return Palauttaa null jos solmulla ei ole lapsia, muuten valitsee
     * todennäköisyydet huomioon ottaen jonkun lapsisolmun ja palauttaa sen.
     */
    public TrieSolmu valitseSolmu() {
        int x = satunnaisluku();
        if (painot.isEmpty()) {
            return null;
        } else {
            return valitse(x);
        }
    }

    /**
     * Metodi joka palauttaa suoraan solmut taulukon indeksin arvon
     *
     * @param solmu Indeksi jota etsitään solmut taulukosta
     * @return null jos solmua ei ole, tai solmu sijainnissa solmut[solmu]
     */
    public TrieSolmu palautaSolmu(int solmu) {
        return solmut[solmu];
    }

    @Override
    public String toString() {
        return "Solmu " + this.solmunArvo + " johon on lisätty "
                + painot.size() + " painoa";
    }

    /**
     * Metodi joka listaa solmun lapsisolmut
     * @return palauttaa String muuttujan jossa on kaikki solmun lapsisolmut
     * listattuna
     */
    public String solmunTiedot() {
        String info = "Solmun alasolmut ovat:";

        for (int solmu : alaSolmut()) {
            info += " ";
            info += String.valueOf(solmu);
        }
        return info;
    }

    /**
     * Poistaa solmun ja sen esiintymien tiedot
     * @param solmu poistettava solmu
     */
    public void poistaSolmu(int solmu) {
        for (int i = 0; i < painot.size(); i++) {
            if (painot.get(i) == solmu) {
                painot.remove(i);
            }
        }
        solmut[solmu] = null;
    }

    /**
     * Palauttaa listan solmun alasolmuja
     * @return alasolmut
     */
    public ArrayList<Integer> alaSolmut() {
        ArrayList<Integer> palautettava = new ArrayList();
        for (TrieSolmu solmu : solmut) {
            if (solmu != null) {
                palautettava.add(solmu.solmunArvo);
            }
        }
        return palautettava;
    }

    /**
     * Tulostaa solmun tiedto
     */
    public void printtaaTiedot() {
        System.out.println(toString());
        System.out.println(solmunTiedot());
    }

    /**
     * tarkistaa onko arvoa olemassa
     * @param arvo etsittävän arvo
     * @return totuusarvo löytyykö solmu tämän solmun alta
     */
    public boolean loytyySolmu(int arvo) {
        return painot.contains(arvo);
    }
}
