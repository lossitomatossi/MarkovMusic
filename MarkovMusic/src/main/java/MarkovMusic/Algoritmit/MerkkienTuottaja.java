package MarkovMusic.Algoritmit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MerkkienTuottaja {

    private Random satunnaisuus;

    public MerkkienTuottaja(long satunnaisAvain) {
        this.satunnaisuus = new Random(satunnaisAvain);
    }

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
