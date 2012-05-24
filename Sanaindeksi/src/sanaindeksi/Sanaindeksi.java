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
        Lukija lukija = new Lukija(testipuu);
        lukija.lisaaTiedosto(new File("testi.txt"));
  
        //System.out.println(testipuu);
        
         testipuu.etsi("rivi");
        
        // TODO:
        //
        // sanahakuun rivitiedon tulostus!
        // tee testejä
        // lisää sanojen loppuun tieto rivistä
        // laita teksti String-taulukkoon
        // lue useampi tiedosto
        // anna tiedostot kutsu vaiheessa
        
    }
    
    
}
