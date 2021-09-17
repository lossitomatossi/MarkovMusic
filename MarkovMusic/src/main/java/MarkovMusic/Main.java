/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic;

import MarkovMusic.Kayttolittyma.Kayttoliittyma;
import java.io.IOException;

/**
 *
 * @author tompp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        kayttoliittyma.kaynnistaKayttoliittyma();
    }
    
}
