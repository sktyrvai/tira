
package sanaindeksi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Sanaindeksi-projektin pääluokka. Sisältää käyttöliittymän, luo Puun ja sen täyttävän Lukijan sekä säilyttää tekstitiedostot.
 * @author Sanna Tyrväinen
 * @version 
 */
public class Sanaindeksi {

    public static Scanner lukija = new Scanner(System.in, "UTF-8");
    public static void main(String[] args) {
                    
        Puu testipuu;
        Lukija puulukija;
        String[] tiedostot = new String[1]; 
        Taulukko[] tekstit; 
        int tiedlkm = args.length;
 
        /*
         * Jos tiedostoje ei ole annettu kutsun yhteydessä 
         */
        if(tiedlkm == 0){
            boolean looppi = true;
            while(looppi){
                
                boolean eiLuku = true;
                while(eiLuku){
                    try{
                        System.out.println("Kuinka monta tiedostoa annat?");
                        tiedlkm = Integer.parseInt(lukija.nextLine());
                        eiLuku = false;
                    } catch (Exception e){
                        System.out.println("");                        
                    }
                }
                
            
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
            /*
             * tiedostot annettu komentorivin yhteydessä
             */
        }   else{ 
            
            tiedostot = args;
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
        
        for(int i= 0;i<tiedostot.length; i++){
            File t = new File(tiedostot[i]);
            tiedostot[i] = t.getName();
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

            System.out.println();
            System.out.println("Anna seuraava etsittävä sana. Anna tyhjä, jos tahdot lopettaa.");
            sana = lukija.nextLine();
        }
        
        
         
        //System.out.println(testipuu);
        // hyväksyy muuten vain utf-8-tekstitedostoja
          

        
        
    }
    
}
