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

    public static Scanner lukija = new Scanner(System.in, "UTF-8");
    //public static Scanner lukija = new Scanner(new InputStreamReader(System.in, "UTF-8"));
    public static void main(String[] args) {
                    
        Puu testipuu;
        Lukija puulukija;
        String[] tiedostot = new String[1]; 
        Taulukko[] tekstit; 
        int tiedlkm = args.length;
 
        
        if(tiedlkm == 0){
            boolean looppi = true;
            while(looppi){
                System.out.println("Kuinka monta tiedostoa annat?");
                tiedlkm = lukija.nextInt();
                lukija.nextLine();
            
                Solmu.setTiedLkm(tiedlkm);            
                tiedostot = new String[tiedlkm];         
            
                System.out.println("Anna tiedostot ("+ tiedlkm +" kpl) välilyönnillä eroteltuna.");
            
                String vastaus = lukija.nextLine();
            
                if(vastaus.length() >0){
                    tiedostot = vastaus.split(" ");
                    if(tiedostot.length == tiedlkm){
                      looppi = false;  
                    } else{
                        System.out.println("Antamiesi tiedostojen lukumäärä ei vastannut antamaasi lukua " +tiedlkm +".");
                    }
                }
                

            }
        }   else{ tiedostot = args;
            tiedlkm = tiedostot.length;         
        }
            
        tekstit = new Taulukko[tiedlkm];
        
        testipuu = new Puu();
        puulukija = new Lukija(testipuu);
        Taulukko teksti;
        
        for(int i= 0; i< tiedlkm; i++){ 
               teksti = puulukija.lisaaTiedosto(new File(tiedostot[i]));
               tekstit[i] = teksti;
        }
       
        System.out.println("..............................");
        System.out.println("Tekstitiedostot luettu.");
        
       
        System.out.println("Anna etsittävä sana tai sanat.");      
        String sana = lukija.nextLine();
        
        while(!sana.equals("")){
            Taulukko[] rivit = testipuu.etsi(sana.toLowerCase());
            int loydetyt = 0;
            if(rivit != null){        
                for(int k = 0; k<rivit.length; k++){     
                    for(int i = 1; i<= rivit[k].getKoko(); i++){ 
                        int rivinro = (Integer) rivit[k].get(i);
                        loydetyt++;
                        System.out.println(tiedostot[k] + " "+rivinro +" "+ tekstit[k].get(rivinro));                             
                    }                
                }
                System.out.println();
                System.out.println("Hakusanalla "+sana+ " löytyi " +loydetyt + " riviä.");
            } else {System.out.println("Sanaa tai sanoja " +sana + " ei löytynyt :(");
            }
            //löytyi kpl hakusanalla+ sana
            System.out.println();
            System.out.println("Anna seuraava etsittävä sana. Anna tyhjä, jos tahdot lopettaa.");
            sana = lukija.nextLine();
        }
        
        
         
        //System.out.println(testipuu);
        // hyväksyy muuten vain utf-8-tekstitedostoja
        
        // TODO:
        //
        // tee testejä       
       
        // yli kahden sanan haku
        
        
    }
    
}
