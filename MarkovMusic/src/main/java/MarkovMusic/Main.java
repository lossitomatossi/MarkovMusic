/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkovMusic;

import MarkovMusic.Kayttolittyma.Kayttoliittyma;
import java.util.Scanner;

/**
 *
 * @author tompp
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.sound.midi.MidiUnavailableException
     * @throws java.io.FileNotFoundException
     * @throws javax.sound.midi.InvalidMidiDataException
     */
    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija);
        kayttoliittyma.kaynnistaKayttoliittyma();
    }

}
