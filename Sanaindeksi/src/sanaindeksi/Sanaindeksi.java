/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanna Tyrväinen
 * @version 18052012
 */
public class Sanaindeksi {

    /**
     * @param args käytettävät tekstitiedostot .txt
     */
    
    public static void main(String[] args) {
                    
        Puu testipuu = new Puu();
        Lukija lukija = new Lukija(testipuu);
        
        if(args.length == 0){
           System.out.println("Anna tekstitiedostot:");
           //tähän joko for-looppi ja jokainen tiedosto erikseen tai sitten kaikki kerralla, kuten yllä
        }
        else{
            for(int i= 0; i< args.length; i++){
                lukija.lisaaTiedosto(new File(args[i]));
            }
        }
        
        File tied = new File("testi.txt");
        lukija.lisaaTiedosto(new File("testi.txt"));
        //lukija.lisaaTiedosto(new File("testi2.txt"));
  
        testipuu.etsi("rivit");
        
       /* Solmu merimies = new Solmu('b');
        merimies.uusiLapsi(new Solmu('s'));
        Solmu[] taulk = merimies.getLapset();
        System.out.println(taulk[0]+" nämä olivat mermiehen lapset");
        */
        
        System.out.println(testipuu);
        
        // TODO:
        //
        // sanahakuun rivitiedon tulostus!
        // tee testejä
        // lisää sanojen loppuun tieto rivistä (eikö tämä ole jo?)
        // Hashmap tekstitiedostoille
        // miten solmu tietää rivinsä? String, jossa tiedosto ja perässä rivit?
        
    }
    
    
}
