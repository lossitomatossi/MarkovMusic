package MarkovMusic.Tietorakenteet;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author tompp
 */
public class TrieSolmu {

    private final TrieSolmu[] solmut;
    private final int[] painot;
    private int yhteensa;
    Random r;
    int solmunArvo = -99;

    /**
     * TrieSolmu on luokka joka toteuttaa Markovin ketjujen solmut
     *
     * @param arvo "avain" tai arvo joka jokaisella solmulla on identifiointia
     * ja läpikäyntiä varten
     */
    public TrieSolmu(int arvo) {
        this.solmut = new TrieSolmu[128];
        this.painot = new int[128];
        this.yhteensa = 0;
        this.r = new Random();
        this.solmunArvo = arvo;
    }

    /**
     * Parametriton muuttuja on käytössä Trien juurisolmujen luomiseksi
     */
    public TrieSolmu() {
        this.solmut = new TrieSolmu[128];
        this.painot = new int[128];
        this.yhteensa = 0;
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
        this.yhteensa += 1;
        painot[x]++;
    }

    /**
     * Getteri yhteensa muuttujalle
     *
     * @return Kokonaisluku joka kertoo montako lasta on yritetty lisätä tälle
     * solmulle
     */
    public int painojenLkm() {
        return yhteensa;
    }

    /**
     * Metodi todennäköisyyksien arpomiseen, eroteltu testauksen
     * varmentamiseksi.
     *
     * @return Palauttaa kokonaisluvun jota käytetään ketjun lasten valintaan.
     */
    public int satunnaisluku() {
        return r.nextInt(yhteensa + 1) - 1;
    }

    public TrieSolmu valitse(int satunnaisluku) {
        int indeksi = 0;
        for (int i = 0; i < solmut.length - 1; i++) {
            satunnaisluku -= painot[i];
            if (satunnaisluku <= 0) {
                indeksi = i;
                break;
            }
        }
        return solmut[indeksi];
    }

    /**
     * Metodi solmujen valitsemiseen.
     *
     * @return Palauttaa null jos solmulla ei ole lapsia, muuten valitsee
     * todennäköisyydet huomioon ottaen jonkun lapsisolmun ja palauttaa sen.
     */
    public TrieSolmu valitseSolmu() {
        int x = satunnaisluku();
        if (yhteensa == 0) {
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
                + this.yhteensa + " painoa";
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
     *
     * @param solmu
     */
    public void poistaSolmu(int solmu) {
        this.yhteensa -= painot[solmu];
        painot[solmu] = 0;
        solmut[solmu] = null;
    }

    /**
     *
     * @return
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
     *
     */
    public void printtaaTiedot() {
        System.out.println(toString());
        System.out.println(solmunTiedot());
    }

    /**
     *
     * @param arvo
     * @return
     */
    public boolean loytyySolmu(int arvo) {
        return painot[arvo] != 0;
    }
}
