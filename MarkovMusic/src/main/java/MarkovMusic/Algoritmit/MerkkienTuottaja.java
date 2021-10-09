package MarkovMusic.Algoritmit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tompp
 */
public class MerkkienTuottaja {

    private Random satunnaisuus;

    /**
     * Luokka jolla voi luoda satunnaissia merkkejä jonka perusteella luoda
     * Markovin ketjuja.
     * @param avain Muuttuja joka annetaan Javan Random.nextInt metodille.
     */
    public MerkkienTuottaja(long satunnaisAvain) {
        this.satunnaisuus = new Random(satunnaisAvain);
    }

    /**
     * Metodi joka palauttaa halutun pituisen listan kokonaislukuja
     * @param pituus Halutun listan pituus
     * @return Lista kokonaislukuja
     */
    public List<Integer> tuotaTaajuuksia(int pituus) {
        List<Integer> taajuudet = new ArrayList<>();
        for (int i = 0; i < pituus; i++) {
            taajuudet.add(satunnaisuus.nextInt());
        }

        return taajuudet;
    }
//    
//    public List<String> tuotaNuotteja(int pituus) {
//        List<String> nuotit = new ArrayList<>();
//        for (int i = 0; i < pituus; i++) {
//        }
//        
//        return nuotit;
//    }

}
