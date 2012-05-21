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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Puu testipuu = new Puu();
        
        File tiedosto = new File("testi.txt");
        Scanner lukija = null;
        try {
            lukija = new Scanner(tiedosto);
            
        } catch (FileNotFoundException ex) {

        }
        int r = 0;
        while(lukija.hasNextLine()){
            r++;
            String rivi = lukija.nextLine();
            String[] sanat = rivi.split(" ");
            for(int i = 0; i< sanat.length; i++){
                testipuu.lisays(sanat[i], r);
            }
            System.out.println(rivi);          
        }
        
        System.out.println(testipuu);
        
        /*String ekaSana = "testaus";     
        Puu puu = new Puu();
        puu.lisays(ekaSana);
        System.out.println(puu);
        puu.lisays("testi");
        puu.lisays("tempaus");
        System.out.println(puu);
        if(puu.etsi("pop")){
            System.out.println("Puu sisältää sanan test");
        }
        * 
        */
        
        // TODO:
        //
        //
        // tee testejä
        //
        // lisää sanojen loppuun tieto rivistä
        // laita teksti String-taulukkoon
        
    }
    
    
}
