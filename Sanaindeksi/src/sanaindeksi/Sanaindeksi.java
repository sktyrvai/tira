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
           System.out.println("Kuinka monta tiedostoa annat?");
            
           System.out.println("Anna tekstitiedostot:");
           //looppi
        }
        else{
            for(int i= 0; i< args.length; i++){
                lukija.lisaaTiedosto(new File(args[i]));
            }
        }
        
        File tied = new File("testi.txt");
        lukija.lisaaTiedosto(new File("testi.txt"));
        //lukija.lisaaTiedosto(new File("testi2.txt"));
  
        testipuu.etsi("rivi");
        
       /* Solmu merimies = new Solmu('b');
        merimies.uusiLapsi(new Solmu('s'));
        Solmu[] taulk = merimies.getLapset();
        System.out.println(taulk[0]+" nämä olivat mermiehen lapset");
        */
        
        System.out.println(testipuu);
        
        // TODO:
        //
        // tee testejä
        // lisää sanojen loppuun tieto rivistä (eikö tämä ole jo?)
        // Hashmap tekstitiedostoille EI!
        // miten solmu tietää rivinsä? String, jossa tiedosto ja perässä rivit? EI!
        // solmulla taulukko, jonka jokaista tiedostoa vastaavassa kohdassa tieto sanan esiintymisestä ko. rivillä
        //
        // Tekstin talletus! Jokainen tiedosto omassa taulukossaan        
        // Tekstin tulostus ja talletus oma olionsa?
        
    }
    
    
}
