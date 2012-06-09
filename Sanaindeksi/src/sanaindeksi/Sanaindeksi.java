/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        String[] tiedostot; 
        Taulukko[] tekstit; 
        int tiedlkm = args.length;
        
        
        if(tiedlkm > 0){
            tiedostot = new String[tiedlkm];
            tekstit = new Taulukko[tiedlkm];
            
            for(int i= 0; i< args.length; i++){ 
                lukija.lisaaTiedosto(new File(args[i]));
            }
        }
        else{
            System.out.println("Kuinka monta tiedostoa annat?");
            tiedlkm = 2;
            tiedostot = new String[tiedlkm];
            tekstit = new Taulukko[tiedlkm];
            System.out.println("Anna tekstitiedostot:");
 
            
        }
        //tekstit = new Taulukko[2];
        //tiedostot = new Tiedostot[2];
        
        Taulukko teksti;
        File tied;
        //for(int i = 0; i<; i++){
        tied = new File("testi.txt");       
        tiedostot[0] = tied.getName();
        teksti = lukija.lisaaTiedosto(tied);
        tekstit[0] = teksti;
        tied = new File("testi2.txt");
        tiedostot[1] = tied.getName();
        teksti = lukija.lisaaTiedosto(tied);
        tekstit[1] = teksti;
        
       Taulukko[] rivit = testipuu.etsi("rivin");
       
        for(int k = 0; k<rivit.length; k++){     
            for(int i = 0; i<rivit[k].getKoko(); i++){ 
                int rivinro = (Integer) rivit[k].get(i+1);
                System.out.println(tiedostot[k] + " "+rivinro +" "+ tekstit[k].get(rivinro));                             
            }
            System.out.println();
                
        }
        
        
  
         
        System.out.println(tiedostot[0] +" "+tekstit[0].get(1));
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
