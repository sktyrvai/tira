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
        
        
        if(tiedlkm == 0){
            System.out.println("Kuinka monta tiedostoa annat?");
            tiedlkm = 2;
            tiedostot = new String[] {"testi.txt", "testi2.txt"};
            //tiedostot = new String[tiedlkm];         
            System.out.println("Anna tiedostot ("+ tiedlkm +" kpl) välilyönnillä eroteltuna.");
            
            for(int i= 0; i< args.length; i++){ 
                lukija.lisaaTiedosto(new File(args[i]));
            }
        }
        else{ tiedostot = args;
            tiedlkm = tiedostot.length;         
        }
            
        tekstit = new Taulukko[tiedlkm];
      
        Taulukko teksti;
        for(int i= 0; i< tiedlkm; i++){ 
               teksti = lukija.lisaaTiedosto(new File(tiedostot[i]));
               tekstit[i] = teksti;
        }
       
        
        /*
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
        
        * 
        */
        System.out.println("..............................");
        System.out.println("Tekstitiedostot luettu.");
        System.out.println("Anna etsittävä sana.");
        Taulukko[] rivit = testipuu.etsi("rivin");
       
        for(int k = 0; k<rivit.length; k++){     
            for(int i = 0; i<rivit[k].getKoko(); i++){ 
                int rivinro = (Integer) rivit[k].get(i+1);
                System.out.println(tiedostot[k] + " "+rivinro +" "+ tekstit[k].get(rivinro));                             
            }
            System.out.println();
                
        }
        
        
  
        
        
        System.out.println(testipuu);
        
        // TODO:
        //
        // tee testejä       
        // Tekstin tulostus ja talletus oma olionsa?
        //monen sanan haku
        // yleistä yli kolmelle tiedostolle
        
    }
    
}
